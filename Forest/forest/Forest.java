import java.util.ArrayList;
import java.util.Collections;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Graphics;

/*
 * ノードを追加するメソッド
 * @param aNode　ノード
 *
 */
public class Forest {

	private ArrayList<Branch> branches;

	private ArrayList<Node> nodes;

	private Rectangle bounds;

	/**
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
	public void arrange(Model aModel) {

	}

	/**
	 *  
	 */
	public void arrange(Node aNode, Point aPoint, Model aModel) {

	}

	public Rectangle bounds() {
		return null;
	}

	/**
	 *  
	 */
	public void draw(Graphics aGraphics) {

	}

	/**
	 *  
	 */
	public void flushBounds() {
		this.bounds = null;

		return;
	}

	public protected void propagate(Model aModel) {
		return null;
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

	public String toString() {
		return null;
	}

	public Node whichOfNodes(Point aPoint) {
		for(Node aNode : this.nodes){
			Rectangle aRectangle = aNode.getBounds();
			if(aRectangle.contains(aPoint))
				return aNode;
		}

		return null;
	}

}


