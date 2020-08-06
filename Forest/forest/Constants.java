package forest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class Constants extends Object{
	/**
	 *
	 *
	 */
	public static final String TagOfTrees = "trees:";

	/**
	 *
	 *
	 */
	public static final String TagOfNodes = "nodes:";

	/**
	 *
	 *
	 */
	public static final String TagOfBranches = "branches:";

	/**
	 *
	 *
	 */
	public static final Color ForegroundColor = Color.black;

	/**
	 *
	 *
	 */
	public static final Color BackgroundColor = Color.white;

	/**
	 *
	 *
	 */
	public static final Font DefaultFont = new Font("Serif",Font.PLAIN,12);

	/**
	 *
	 *
	 */
	public static final Point Margin = new Point(2,1);

	/**
	 *
	 *
	 */
	public static final Point Interval = new Point(25,2);

	/**
	 *
	 *
	 */
	public static final Integer UnKnown = -1;

	/**
	 *
	 *
	 */
	public static final Integer UnVisited = 0;

	/**
	 *
	 *
	 */
	public static final Integer Visited = 1;

	/**
	 *
	 *
	 */
	public static final Integer SleepTick = 30;
}
