package forest;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class ForestController {

	private Point current;

	private Point previous;

	private ForestView view;

	private ForestModel model;

	public ForestController() {
		super();
		model = null;
		view = null;
		previous = null;
		current = null;
		return;
	}

	public void mouseClicked(MouseEvent a) {
		Point aPoint = aMouseEvent.getPoint();
		aPoint.translate(view.scrollAmount().x, view.scrollAmount().y);
		System.out.println(aPoint);
		return;
	}

	/**
	 *  
	 */
	public void mouseDragged(MouseEvent aMouseEvent) {
		Cursor aCursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);
		current = aMouseEvent.getPoint();
		int x = current.x - previous.x;
		int y = current.y - previous.y;
		Point point = new Point(x, y);
		view.scrollBy(point);
		view.repaint();
		previous = current;
		return;
	}

	public void mouseEntered(MouseEvent aMouseEvent) {
		return;
	}

	public void mouseExited(MouseEvent aMouseEvent) {
		return;
	}

	public void mouseMoved(MouseEvent aMouseEvent) {
		return;
	}

	public void mousePressed(MouseEvent aMouseEvent) {
		Cursor aCursor = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);
		current = aMouseEvent.getPoint();
		previous = current;
		return;
	}

	public void mouseReleased(MouseEvent aMouseEvent) {
		Cursor aCursor = Cursor.getDefaultCursor();
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);
		current = aMouseEvent.getPoint();
		previous = current;
		return;
	}

	public void mouseWheelMoved(MouseWheelEvent aMouseWheelEvent) {
		return;
	}

	public void setModel(ForestModel aModel) {
		model = aModel;
		return;
	}

	public void setView(ForestView aView) {
		view = aView;
		view.addMouseListener(this);
		view.addMouseMotionListener(this);
		view.addMouseWheelListener(this);
		return;
	}

	public String toString() {
		Class<?> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[model=");
		aBuffer.append(model);
		aBuffer.append(",view=");
		aBuffer.append(view);
		aBuffer.append("]");
		return aBuffer.toString();
	}

}
