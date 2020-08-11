package forest;

import java.util.ArrayList;
import java.util.Collections;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Graphics;

/**
 * Forestクラス
 *
 */
public class Forest extends Object{

	private ArrayList<Branch> branches;

	private ArrayList<Node> nodes;

	private Rectangle bounds;

	/**
	 * Forestのコンストラクタ 
	 *
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
	 *
	 */
	public void addBranch(Branch aBranch) {
		this.branches.add(aBranch);
		this.flushBounds();

		return;
	}

	/**
	 * ノードを追加するメソッド
	 * @param aNode　ノード
	 *
	 */
	public void addNode(Node aNode) {
		this.nodes.add(aNode);
		this.flushBounds();

		return;
	}

	/**
	 * 樹状整列のトップのメソッド
	 *
	 */
	public void arrange() {
		try {
			this.arrange(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return;
	}

	/**
	 * 樹状整列のセカンドレベルのメソッド
	 * @param aModel
	 */
	public void arrange(ForestModel aModel) {

		Integer counter = 0;
		for(Node aNode: this.nodes){
			Integer height = aNode.getExtent().y + Constants.Margin.y + Constants.Interval.y;
			aNode.setStatus(Constants.UnVisited);
			aNode.setLocation(new Point(0, height*counter++));
		}

		Point aPoint = new Point(0,0);
		ArrayList<Node> rootNodes = this.rootNodes();
		for(Node aNode: rootNodes){
			Point secondPoint = this.arrange(aNode, aPoint, aModel);
			aPoint = new Point(0, secondPoint.y + Constants.Interval.y);
		}

		this.flushBounds();
		return;
	}

	/**
	 *
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
	 *  
	 */
	public Rectangle bounds() {
		if (this.bounds == null) this.bounds = new Rectangle();
		this.nodes.forEach(aNode -> this.bounds.add(aNode.getBounds()));

		return this.bounds;
	}

	/**
	 *  
	 */
	public void draw(Graphics aGraphics) {
		this.branches.forEach( aBranch -> aBranch.draw(aGraphics) );
		this.nodes.forEach( aNode -> aNode.draw(aGraphics) );
	}

	/**
	 *  
	 */
	public void flushBounds() {
		this.bounds = null;

		return;
	}

	protected void propagate(ForestModel aModel) {
		return;
	}

	public ArrayList<Node> rootNodes() {
		return null;
	}

	/**
	 * ノードをノード名でソートするメソッド
	 * @param nodeCollection ノード
	 * return ソートされたノード
	 *
	 */
	public ArrayList<Node> sortNodes(ArrayList<Node> nodeCollection) {
//		Collections.sort(nodeCollection);

		return nodeCollection;
	}

	/**
	 * 子ノードを返すメソッド
	 * @param aNode ノード
	 * return nodeList 子ノード
	 *
	 */
	public ArrayList<Node> subNodes(Node aNode) {
		ArrayList<Node> nodeList = new ArrayList<>();
		for(Branch aBranch : this.branches){
			if(aBranch.start().equals(aNode))
				nodeList.add(aBranch.end());
		}

		return nodeList;
	}

	/**
	 * 親ノードを返すメソッド
	 * @param aNode ノード
	 * return nodeList 親ノード
	 *
	 */
	public ArrayList<Node> superNode(Node aNode) {
		ArrayList<Node> nodeList = new ArrayList<>();
		for(Branch aBranch : this.branches){
			if(aBranch.end().equals(aNode))
				nodeList.add(aBranch.start());
		}

		return nodeList;
	}

	/**
	 * クラスを文字列に変換するメソッド
	 * return aBuffer.toString()
	 *
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
	 * return aNode もしくはnull
	 *
	 */
	public Node whichOfNodes(Point aPoint) {
		for(Node aNode : this.nodes){
			Rectangle aRectangle = aNode.getBounds();
			if(aRectangle.contains(aPoint))
				return aNode;
		}

		return null;
	}

}


