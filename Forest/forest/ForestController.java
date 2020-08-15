package forest;

import java.awt.Point;
import java.awt.event.MouseEvent;
import mvc.Controller;

public class ForestController extends Controller {
	/**
	 * このクラスのインスタンスを生成するコンストラクタ
	 */
	public ForestController() {
		super();
		return;
	}

	/**
	 * マウスをクリックした時に動作するメソッド
	 * @param aMouseEvent マウスイベント
	 */
	@Override
	public void mouseClicked(MouseEvent aMouseEvent) {
		Point aPoint = aMouseEvent.getPoint();
		ForestView aView = (ForestView)super.view;
		Node aNode = aView.whichOfNodes(aPoint);

		if(aNode != null) System.out.println(aNode.getName());
		return;
	}
}
