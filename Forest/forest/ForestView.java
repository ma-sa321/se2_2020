package forest;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Point;
import mvc.View;

@SuppressWarnings("serial")
public class ForestView extends View {

	/**
	 * このクラスのインスタンスを生成するコンストラクタ
	 * @param aModel このビューの依存物となるモデル
	 */
	public ForestView(ForestModel aModel) {
		super(aModel, new ForestController());
		return;
	}

	/**
	 * 画像の描画を行うメソッド
	 * @param aGraphics グラフィックス（描画コンテクスト）
	 */
	@Override
	public void paintComponent(Graphics aGraphics) {
		// 樹状整列の境界領域を求め、その領域と高さの画像を生成する。
		int width = this.getWidth();
		int height = this.getHeight();
		aGraphics.setColor(Constants.BackgroundColor);
		aGraphics.fillRect(0, 0, width, height);

		ForestModel aModel = (ForestModel)this.model;
		if (aModel == null) { return; }
		BufferedImage picture = this.model.picture();
		if (picture == null) { return; }

		Integer x = 0 - this.scrollAmount().x;
		Integer y = 0 - this.scrollAmount().y;
		aGraphics.drawImage(picture, x, y, null);
		return;
	}

	/**
	 * 座標からNodeを取り出すメソッド
	 * @param aPoint 座標
	 * @return ノード
	 */
	public Node whichOfNodes(Point aPoint) {
		Integer x = aPoint.x + this.scrollAmount().x;
		Integer y = aPoint.y + this.scrollAmount().y;
		Point nodePoint = new Point(x, y);
		ForestModel aModel = (ForestModel)this.model;
		Node aNode = aModel.forest().whichOfNodes(nodePoint);
		return aNode;
	}
}
