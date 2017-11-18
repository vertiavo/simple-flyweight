package com.vertiavo;

import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class PieceImpl implements Piece {

    public static final int TILESIZE = 32;
    private static Image image = new ImageIcon("src/main/resources/pieces4.png").getImage();
    private static Map<Integer, Piece> pieces = new HashMap<>();

    private int index;
    private int x;
    private int y;

    private PieceImpl(int index) {
        this.index = index;
    }

    public void draw(Graphics2D g, int x, int y) {
        this.x = x;
        this.y = y;
        g.drawImage(image, x, y, x+1, y+1,
                index*TILESIZE, 0, (index+1)*TILESIZE, TILESIZE, null);
    }

    public static Piece getPiece(int index) {
        if (!pieces.containsKey(index)) {
            pieces.put(index, new PieceImpl(index));
        }

        return pieces.get(index);
    }

    public int getX() { return x; }

    public int getY() {return y; }

    public void moveTo(int xx, int yy) { x=xx; y=yy; }

    @Override
    public Piece reverseDecoration() {
        return null;
    }
}
