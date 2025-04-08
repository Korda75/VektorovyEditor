package cz.uhk.veditor.grobjekty;

import java.awt.*;

public class Triangle extends AbstractGeomObject {
    protected int ax;
    protected int bx;
    protected double cx;
    protected int ay;
    protected int by;
    protected double cy;

    public Triangle(Point position, int ax, int ay, int bx, int by, double cx, double cy, Color color) {
        super(position, color);
        this.ax = ax;
        this.bx = bx;
        this.cx = cx;
        this.ay = ay;
        this.by = by;
        this.cy = cy;
    }


    @Override
    public boolean contains(int x, int y) {

        int a = position.x;
        int b = position.y;

        double cx = (ax/2) * (ax * Math.sqrt(3));
        double cy = (ay/2) * (ay * Math.sqrt(3));

        double l = cx/2;
        double k = cy/2;

        return l<=k;

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawPolygon(new int[] {position.x+ax, position.x+bx, (int) (position.x+cx)}, new int[] {position.y+ay, position.y+by,(int)(position.y+cy)}, 3);
    }
}
