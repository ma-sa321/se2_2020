package forest;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

/**
 * 樹状整列におけるMVCのモデル（M）を担うクラス
*/
public class Branch extends Object
{
    /**
     * ブランチ（枝）の始点となるノードを記憶するフィールド
     */
    private Node start;

    /**
     * ブランチ（枝）の終点となるノードを記憶するフィールド
     */
    private Node end;

    /**
     * このクラスのインスタンスを生成するコンストラクタ
     * @param from ブランチ（枝）の始点となるノード
     * @param to ブランチ（枝）の終点となるノード
     */
    public Branch(Node from, Node to) {
        super();
        this.start = from;
        this.end = to;
        return;
    }

    /**
     * ブランチ（枝）を描画するメソッド
     * @param aGraphics グラフィクス（描画コンテクスト）
     */
    public void draw(Graphics aGraphics) {
        Graphics2D aGraphics2d = (Graphics2D)aGraphics;
        aGraphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        aGraphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // ブランチ（枝）の始点座標を計算する。
        Point location = this.start.getLocation();
        Point extent = this.start.getExtent();
        Integer x1 = location.x + extent.x;
        Integer y1 = location.y + (extent.y / 2);

        // ブランチ（枝）の終点座標を計算する。
        location = this.end.getLocation();
        extent = this.end.getExtent();
        Integer x2 = location.x;
        Integer y2 = location.y + (extent.y / 2);

        // ブランチ（枝）の線を描画コンテクストへ描き出す。
        aGraphics.setColor(Constants.ForegroundColor);
        aGraphics.drawLine(x1, y1, x2, y2);

        return;
    }

    /**
     * ブランチ（枝）の終点となるノードを応答するメソッド
     * @return 終点ノード
     */
    public Node end() { return this.end; }

    /**
     * ブランチ（枝）の始点となるノードを応答するメソッド
     * @return 始点ノード
     */
    public Node start() { return this.start; }

    /**
     * 自分自身を文字列に変換するメソッド
     * @return 自分自身を表す文字列
     */
    public String toString() {
        StringBuffer aBuffer = new StringBuffer();
        Class<?> aClass = this.getClass();
        aBuffer.append(aClass.getName());
        aBuffer.append("[");
        aBuffer.append(this.start.getName());
        aBuffer.append(",");
        aBuffer.append(this.end.getName());
        aBuffer.append("]");
        return aBuffer.toString();
    }
}