package forest;

import java.util.ArrayList;
import java.util.Collections;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Graphics;

/**
 * 樹状整列を担うクラス
 */
public class Forest extends Object {

	/**
	 * ブランチを記憶するフィールド
	 */
	private ArrayList<Branch> branches;

	/**
	 * ノードを記録するフィールド
	 */
	private ArrayList<Node> nodes;

	/**
	 * 座標空間内の領域を記憶するフィールド
	 */
	private Rectangle bounds;

	/**
	 * このクラスのインスタンスを生成するコンストラクタ
	 */
	public Forest() {
		this.nodes = new ArrayList<Node>();
		this.branches = new ArrayList<Branch>();
		this.bounds = null;
		return;
	}

	/**
	 * ブランチを追加するメソッド
	 * @param aBranch ブランチ
	 */
	public void addBranch(Branch aBranch) {
		this.branches.add(aBranch);
		this.flushBounds();
		return;
	}

	/**
	 * ノードを追加するメソッド
	 * @param aNode　ノード
	 */
	public void addNode(Node aNode) {
		this.nodes.add(aNode);
		this.flushBounds();
		return;
	}

	/**
	 * 樹状整列のトップのメソッド
	 */
	public void arrange() {
		try { this.arrange(null); }
		catch (Exception e) { e.printStackTrace(); }
		return;
	}

	/**
	 * 樹状整列のセカンドレベルのメソッド
	 * @param aModel モデル
	 */
	public void arrange(ForestModel aModel) {
		Integer counter = 0;
		for(Node aNode: this.nodes) {
			Integer height = aNode.getExtent().y + Constants.Margin.y + Constants.Interval.y;
			aNode.setStatus(Constants.UnVisited);
			aNode.setLocation(new Point(0, height*counter++));
		}

		Point aPoint = new Point(0,0);
		ArrayList<Node> rootNodes = this.rootNodes();
		for(Node aNode: rootNodes) {
			Point secondPoint = this.arrange(aNode, aPoint, aModel);
			aPoint = new Point(0, secondPoint.y + Constants.Interval.y);
		}
		this.flushBounds();
		return;
	}

	/**
	 * 樹状整列の再帰レベルのメソッド
	 * @param aNode ノード
	 * @param aPoint 座標
	 * @param aModel モデル
	 * @return 座標
	 */
	protected Point arrange(Node aNode, Point aPoint, ForestModel aModel) {
		aNode.setStatus(Constants.Visited);
		aNode.setLocation(aPoint);
		this.propagate(aModel);

		Point extent = aNode.getExtent();
		ArrayList<Node> subNodes = this.subNodes(aNode);
		//子ノードがない時
		if (subNodes.isEmpty()) {
			Integer width = aPoint.x + extent.x;
			Integer height = aPoint.y + extent.y;
			extent = new Point(width, height);
			return extent;
		}

		Integer width = aPoint.x + extent.x;
		Integer height = aPoint.y;
		Integer x = width + Constants.Interval.x;
		Integer y = height;
		Integer top = height;

		for (Node subNode: subNodes) {
			if (subNode.getStatus() == Constants.UnVisited) {
				extent = this.arrange(subNode, new Point(x, y), aModel);
				Integer h = y + subNode.getExtent().y;
				y = extent.y > h ? extent.y : h; //参考演算子 true:false
				width = extent.x > width ? extent.x : width;
				height = extent.y > height ? extent.y : height;
				y = y + Constants.Interval.y;
			}
		}

		y = y - Constants.Interval.y;
		Integer h = aNode.getExtent().y;
		if (y > (aPoint.y + h)) {
			y = top + ((y - top - h) / 2);
			aNode.setLocation(new Point(aPoint.x, y));
			this.propagate(aModel);
		}
		height = height > h ? height : h;
		extent = new Point(width, height);
		return extent;
	}

	/**
	 * 描画領域を応答するメソッド
	 * @return 描画領域
	 */
	public Rectangle bounds() {
		if (this.bounds == null) this.bounds = new Rectangle();
		this.nodes.forEach(aNode -> this.bounds.add(aNode.getBounds()));
		return this.bounds;
	}

	/**
	 * フォレストを描くメソッド
	 * @param aGraphics グラフィックス（描画コンテクスト）
	 */
	public void draw(Graphics aGraphics) {
		this.branches.forEach( aBranch -> aBranch.draw(aGraphics) );
		this.nodes.forEach( aNode -> aNode.draw(aGraphics) );
	}

	/**
	 * 描画領域をリセットするメソッド
	 */
	public void flushBounds() {
		this.bounds = null;
		return;
	}

	/**
	 * チックタックの間、スリープし、モデルが変化したと騒ぐメソッド
	 * @param aModel モデル
	 */
	protected void propagate(ForestModel aModel) {
		if(!(aModel == null)) {
			try{
				aModel.changed();
				Thread.sleep(Constants.SleepTick);
			} catch(Exception e) {
				e.printStackTrace();
			}
			this.flushBounds();
			aModel.changed();
		}
		return;
	}

	/**
	 * フォレストの根元（ルート）となるノード群を応答するメソッド
	 * @return ルート
	 */
	public ArrayList<Node> rootNodes() {
		ArrayList<Node> endList = new ArrayList<>();
		this.branches.forEach(aBranch -> endList.add(aBranch.end()));

		ArrayList<Node> roots = new ArrayList<>();
		this.nodes.forEach((Node aNode)->
		{
			if(!endList.contains(aNode)) roots.add(aNode);
		});
		return roots;
	}

	/**
	 * ノードをノード名でソートするメソッド
	 * @param nodeCollection ノード
	 * @return ソートされたノード
	 */
	public ArrayList<Node> sortNodes(ArrayList<Node> nodeCollection) {
		ArrayList<String> sortNameArray = new ArrayList<>();
		ArrayList<Node> sortResultArray = new ArrayList<>();
		for(Node aNode : nodeCollection) { sortNameArray.add(aNode.getName()); }
		Collections.sort(sortNameArray);
		for(String sortName : sortNameArray) {
			for(Node aNode : nodeCollection) { if(sortName.equals(aNode.getName())) sortResultArray.add(aNode); }
		}
		return sortResultArray;
	}

	/**
	 * 子ノードを返すメソッド
	 * @param aNode ノード
	 * @return 子ノード
	 */
	public ArrayList<Node> subNodes(Node aNode) {
		ArrayList<Node> nodeList = new ArrayList<>();
		for(Branch aBranch : this.branches) { if(aBranch.start().equals(aNode)) nodeList.add(aBranch.end()); }

		return sortNodes(nodeList);
	}

	/**
	 * 親ノードを返すメソッド
	 * @param aNode ノード
	 * @return 親ノード
	 */
	public ArrayList<Node> superNode(Node aNode) {
		ArrayList<Node> nodeList = new ArrayList<>();
		for(Branch aBranch : this.branches){ if(aBranch.end().equals(aNode)) nodeList.add(aBranch.start());	}
		return sortNodes(nodeList);
	}

	/**
	 * クラスを文字列に変換するメソッド
	 * @return 自分自身を表す文字列
	 */
	public String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<?> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[bounds=");
		aBuffer.append(this.bounds);
		aBuffer.append(", nodes=");
		aBuffer.append(this.nodes);
		aBuffer.append(", branches=");
		aBuffer.append(this.branches);
		aBuffer.append("]");
		return aBuffer.toString();
	}

	/**
	 * 座標にノードが存在するかどうかを調べるメソッド
	 * @param aPoint 座標
	 * @return aNode もしくはnull
	 */
	public Node whichOfNodes(Point aPoint) {
		for(Node aNode : this.nodes) {
			Rectangle aRectangle = aNode.getBounds();
			if(aRectangle.contains(aPoint)) return aNode;
		}
		return null;
	}

}
