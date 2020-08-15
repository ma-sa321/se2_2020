package forest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

/**
 * 樹状整列で使う定数まとめるクラス
 */
public class Constants extends Object{
	/**
	 * 樹状整列のtxtファイルのタグ「ツリー」を表す定数
	 */
	public static final String TagOfTrees = "trees:";

	/**
	 * 樹状整列のtxtファイルのタグ「ノード」を表す定数
	 */
	public static final String TagOfNodes = "nodes:";

	/**
	 * 樹状整列のtxtファイルのタグ「ブランチ」を表す定数
	 */
	public static final String TagOfBranches = "branches:";

	/**
	 * ノードのラベルの文字色を表す定数
	 */
	public static final Color ForegroundColor = Color.black;

	/**
	 * ノードのラベルの背景色を表す定数
	 */
	public static final Color BackgroundColor = Color.white;

	/**
	 * ノードのラベルの文字のフォントを表す定数
	 */
	public static final Font DefaultFont = new Font("Serif",Font.PLAIN,12);

	/**
	 * ノードのラベルの枠と文字のマージンを表す定数
	 */
	public static final Point Margin = new Point(2,1);

	/**
	 * ノードのラベル同士の間隔を表す定数
	 */
	public static final Point Interval = new Point(25,2);

	/**
	 * ノードたちの深さ優先に辿るときの状態「未定」を表す定数
	 */
	public static final Integer UnKnown = -1;

	/**
	 * ノードたちの深さ優先に辿るときの状態「未訪問」を表す定数
	 */
	public static final Integer UnVisited = 0;

	/**
	 * ノードたちの深さ優先に辿るときの状態「訪問済」を表す定数
	 */
	public static final Integer Visited = 1;

	/**
	 * 樹状整列アニメーションの時間間隔を表す定数
	 */
	public static final Integer SleepTick = 30;
}
