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

	}

	/*
	 * マウスのボタンをクリックしたときに動作するメソッドです。
	 */
	public void mouseClicked(MouseEvent aMouseEvent) {

	}

	/*
	 * マウスドラッグ（ボタンを押しながら移動）したときに動作するメソッドです。
	 */
	public void mouseDragged(MouseEvent aMouseEvent) {

	}

	/*
	 * マウスがウィンドウに入った時に動作するメソッドです。
	 */
	public void mouseEntered(MouseEvent aMouseEvent) {

	}

	/*
	 * マウスがウィンドウに出たときに動作するメソッドです。
	 */
	public void mouseExited(MouseEvent aMouseEvent) {

	}

	/*
	 * マウスがウィンドウ内でただ移動したときに動作するメソッドです。
	 */
	public void mouseMoved(MouseEvent aMouseEvent) {

	}

	/*
	 * マウスのボタンが押されたときに動作するメソッドです。
	 */
	public void mousePressed(MouseEvent aMouseEvent) {

	}

	/*
	 * マウスのボタンが離されたときに動作するメソッドです。
	 */
	public void mouseReleased(MouseEvent aMouseEvent) {

	}

	/*
	 * マウスのホイールが回されたときに動作するメソッドです。
	 */
	public void mouseWheelMoved(MouseWheelEvent aMouseWheelEvent) {

	}

	/*
	 * モデルを設定するメソッドです。
	 */
	public void setModel(Model aModel) {

	}

	/*
	 * ビューを設定するメソッドです。
	 */
	public void setView(View aView) {

	}

	/*
	 * 自分自身を文字列に変換するメソッドです。
	 */
	public String toString() {
		return null;
	}

}
