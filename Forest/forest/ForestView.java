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

public class ForestView  extends Model{

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
		int width = this.getWidth();
		int height = this.getHeight();
		aGraphics.setColor(Color.lightGray);
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
		return (new Point(x, y));
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

	public void update() {
		this.repaint(0, 0, this.getWidth(), this.getHeight());
		return;
	}

	/**
	 *  
	 */
	public Node whichOfNodes(Point aPoint) {
		Integer x = aPoint.x;
		Integer y = aPoint.y;
		Point nodePoint = new Point(x, y);
		ForestModel aModel = this.model;
		Node aNode = aModel.whichOfNodes(nodePoint);
		return aNode;
	}
}
