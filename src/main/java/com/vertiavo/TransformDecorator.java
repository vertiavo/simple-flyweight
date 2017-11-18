package com.vertiavo;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class TransformDecorator extends Decorator {

    private AffineTransform newTransform;

    public TransformDecorator(Piece piece, AffineTransform newTransform) {
        super(piece);
        this.newTransform = newTransform;
    }

    @Override
    public void draw(Graphics2D g, int x, int y) {
        AffineTransform oldTransform = g.getTransform();

        g.transform(this.newTransform);
        this.piece.draw(g, x, y);
        g.setTransform(oldTransform);
    }


}
