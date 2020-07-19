package forest;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
/**
 * 樹状整列におけるMVCのモデル（M）を担うクラスになります。
*/
public class Branch extends Object
{
    /**
     * ブランチ（枝）の始点となるノードを記憶するフィールドです。
     */
    private Node start;

    /**
     * ブランチ（枝）の終点となるノードを記憶するフィールドです。
     */
    private Node end;

    /**
     * このクラスのインスタンスを生成するコンストラクタです。
     * @param from ブランチ（枝）の始点となるノード
     * @param to ブランチ（枝）の終点となるノード
     */
    public Branch(Node from, Node to)
    {
        super();

        this.start = from;
        this.end = to;

        return;
    }

    /**
     * ブランチ（枝）を描画するメソッドです。
     * @param aGraphics グラフィクス（描画コンテクスト）
     */
    public void draw(Graphics aGraphics)
    {
        
    }

    /**
     * ブランチ（枝）の終点となるノードを応答するメソッドです。
     * @return 終点ノード
     */
    public Node end()
    {
        return this.end;
    }

    /**
     * ブランチ（枝）の始点となるノードを応答するメソッドです。
     * @return 始点ノード
     */
    public Node start()
    {
        return this.start;
    }

    /**
     * 自分自身を文字列に変換するメソッドです。
     * @return 自分自身を表す文字列
     */
    public String toString()
    {
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