import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.event.MouseInputAdapter;

public class Controller {

	/*
	 * マウスの現在の位置を記憶するフィールドです。
	 */
	private Point current;

	/*
	 * 樹状整列におけるMVCのモデル（M）を記憶するフィールドです。
	 */
	private Model model;

	/*
	 * マウスの直近の位置を記憶するフィールドです。
	 */
	private Point previous;

	/*
	 * 樹状整列におけるMVCのビュー（V）を記憶するフィールドです。
	 */
	private View view;

	/*
	 * 樹状整列におけるMVCのモデル(M)を記憶するフィールドです。
	 */
	private Model model;

	/*
	 * 
	 */
	private MouseInputAdapter mouseInputAdapter;

	public Controller() {
		super();
		model = null;
		view = null;
		previous = null;
		current = null;
		return;
	}

	/*
	 * マウスのボタンをクリックしたときに動作するメソッドです。
	 */
	public void mouseClicked(MouseEvent aMouseEvent) {
		Point aPoint = aMouseEvent.getPoint();
		aPoint.translate(view.scrollAmount().x, view.scrollAmount().y);
		System.out.println(aPoint);
		return;
		// 変更が必要
	}

	/*
	 * マウスドラッグ（ボタンを押しながら移動）したときに動作するメソッドです。
	 */
	public void mouseDragged(MouseEvent aMouseEvent) {
		// 変更が必要
	}

	/*
	 * マウスがウィンドウに入った時に動作するメソッドです。
	 */
	public void mouseEntered(MouseEvent aMouseEvent) {
		return;
	}

	/*
	 * マウスがウィンドウに出たときに動作するメソッドです。
	 */
	public void mouseExited(MouseEvent aMouseEvent) {
		return;
	}

	/*
	 * マウスがウィンドウ内でただ移動したときに動作するメソッドです。
	 */
	public void mouseMoved(MouseEvent aMouseEvent) {
		return;
	}

	/*
	 * マウスのボタンが押されたときに動作するメソッドです。
	 */
	public void mousePressed(MouseEvent aMouseEvent) {
		// 変更必要
	}

	/*
	 * マウスのボタンが離されたときに動作するメソッドです。
	 */
	public void mouseReleased(MouseEvent aMouseEvent) {
		// 変更必要
	}

	/*
	 * マウスのホイールが回されたときに動作するメソッドです。
	 */
	public void mouseWheelMoved(MouseWheelEvent aMouseWheelEvent) {
		return;
	}

	/*
	 * モデルを設定するメソッドです。
	 */
	public void setModel(Model aModel) {
		model = aModel;
		return;
	}

	/*
	 * ビューを設定するメソッドです。
	 */
	public void setView(View aView) {
		view = aView;
		view.addMouseListener(this);
		view.addMouseMotionListener(this);
		view.addMouseWheelListener(this);
		return;
	}

	/*
	 * 自分自身を文字列に変換するメソッドです。
	 */
	public String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<?> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[forestModel=");
		aBuffer.append(model);
		aBuffer.append(",forestView=");
		aBuffer.append(view);
		aBuffer.append("]");
		return aBuffer.toString();
	}

}
