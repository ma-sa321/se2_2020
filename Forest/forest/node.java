package forest;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Node  extends Object{

	private Point extent;

	private Point location;

	private Stirng name;

	private Integer status;

	public Node(String aString) {

	}

	public void draw(Graphics aGraphics) {

	}

	public Rectangle getBounds() {
		Rectangle aRectangle = new Rectangle(this.location, this.extent);
		return aRectangle;
	}

	public Point getExtent() {
		return this.extent;
	}

	public Point getLocation() {
		return this.location;
	}

	public String getName() {
		return this.name;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setExtent(Point aPoint) {
		this.extent = aaPoint;
		return;
	}

	public void setLocation(Point aPoint) {
		this.location = aPoint;
		return;
	}

	public void setName(String aString) {
		this.name = aString;
		return;
	}

	public void setStatus(Integer anInteger) {
		this.status = anInteger;
		return;
	}

	protected int stringHeight(String string) {
		FontMetrics aFontMetrics = this.getFontMetrics(string);
		return aFontMetrics.getHeight();
	}

	protected int stringWidth(String string) {
		FontMetrics aFontMetrics = this.getFontMetrics(string);
		return aFontMetrics.getWidth();
	}

	public String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<?> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[name=");
		aBuffer.append(this.name);
		aBuffer.append(",location=");
		aBuffer.append(this.location);
		aBuffer.append(",extent=");
		aBuffer.append(this.extent);
		aBuffer.append(",status=");
		aBuffer.append(this.status);
		aBuffer.append("]");
		return aBuffer.toString();
	}

}
