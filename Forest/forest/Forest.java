package forest;

import java.util.ArrayList;
import java.util.Collections;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Graphics;

/*
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
	 * 樹上整列のトップのメソッド
	 *
	 */
	public void arrange() {
		this.arrange(null);

		return;
	}

	/**
	 *  
	 */
	public void arrange(ForestModel aModel) {
		return;
	}

	/**
	 *  
	 */
	protected Dimension arrange(Node aNode, Point aPoint, ForestModel aModel) {
		return null;
	}

	public Rectangle bounds() {
		return null;
	}

	/**
	 *  
	 */
	public void draw(Graphics aGraphics) {
		return;
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
		Collections.sort(nodeCollection);

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


