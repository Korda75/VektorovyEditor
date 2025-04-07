package cz.uhk.veditor.grobjekty;

import java.awt.*;

public class Rectangle extends AbstractGeomObject {
    protected int a;
    protected int b;

    public Rectangle(Point position, int a, int b, Color color) {
        super(position, color);
        this.a = a;
        this.b = b;
    }

    public Rectangle(Point point, int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean contains(int x, int y) {
        int a = position.x;
        int b = position.y;

        int l = a*b;
        int k = a*b;

        return l<=k;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawRect(position.x, position.y, a, b);
    }
}
