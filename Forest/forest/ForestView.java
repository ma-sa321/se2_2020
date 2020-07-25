import java.util.Collection;

public class View {

	private Controller controller;

	private Model model;

	private Point offset;


	private Collection<FramePoint> framePoint;

	/**
	 *  
	 */
	public void paintComponent(Graphics aGraphics) {

	}

	/**
	 *  
	 */
	public void scrollBy(Point aPoint) {

	}

	/**
	 *  
	 */
	public void scrollTo(Point aPoint) {

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

	}

	/**
	 *  
	 */
	public Node whichOfNodes(Point aPoint) {
		return null;
	}

}
