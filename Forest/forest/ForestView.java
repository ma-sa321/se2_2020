package forest;

import java.util.Collection;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import mvc.View;

@SuppressWarnings("serial")
public class ForestView extends View{

	private ForestController controller;

	private ForestModel model;

	private Point offset;


	/**
	 *  
	 */

	public ForestView(ForestModel aModel) {
		super();
		model = aModel;
		return;
	}

	public void paintComponent(Graphics aGraphics) {
		aGraphics = model.picture().createGraphics();

		// 樹状整列の境界領域を求め、その領域と高さの画像を生成する。
		Forest forest = model.forest();
		Rectangle aRectangle = forest.bounds();

		int width = (int)aRectangle.getWidth();
		int height = (int)aRectangle.getHeight();
		aGraphics.setColor(Constants.BackgroundColor);
		aGraphics.fillRect(0, 0, width, height);

		ForestModel aModel = this.model;
		if (aModel == null) {
			 return; 
		}
		BufferedImage picture = model.picture();
		if (picture == null) {
			 return;
		}
		aGraphics.drawImage(picture, offset.x, offset.y, null);
		return;
	}

	/**
	 *  
	 */
	public void scrollBy(Point aPoint) {
		int x = offset.x + aPoint.x;
		int y = offset.y + aPoint.y;
		this.scrollTo(new Point(x, y));
		return;
	}

	/**
	 *  
	 */
	public void scrollTo(Point aPoint) {
		int x = 0 - offset.x;
		int y = 0 - offset.y;
		return;
	}

	/**
	 *  
	 */
	public String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<?> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[model=");
		aBuffer.append(model);
		aBuffer.append(",offset=");
		aBuffer.append(offset);
		aBuffer.append(",controller=");
		aBuffer.append(controller);
		aBuffer.append("]");
		return aBuffer.toString();
	}

	// public void update() {
	// 	this.repaint(0, 0, this.getWidth(), this.getHeight());
	// 	return;
	// }

	/**
	 *  
	 */
	public Node whichOfNodes(Point aPoint) {
		Integer x = aPoint.x;
		Integer y = aPoint.y;
		Point nodePoint = new Point(x, y);
		Forest forest = model.forest();
		Node aNode = forest.whichOfNodes(nodePoint);
		return aNode;
	}
}
