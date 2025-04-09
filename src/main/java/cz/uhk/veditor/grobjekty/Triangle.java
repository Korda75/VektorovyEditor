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
        // Spočítáme absolutní souřadnice vrcholů trojúhelníku
        double x1 = position.x + ax;
        double y1 = position.y + ay;

        double x2 = position.x + bx;
        double y2 = position.y + by;

        double x3 = position.x + cx;
        double y3 = position.y + cy;

        // Vypočteme "barycentrické" souřadnice

        double denominator = ((y2 - y3) * (x1 - x3) + (x3 - x2) * (y1 - y3));
        double a = ((y2 - y3) * (x - x3) + (x3 - x2) * (y - y3)) / denominator;
        double b = ((y3 - y1) * (x - x3) + (x1 - x3) * (y - y3)) / denominator;
        double c = 1 - a - b;
        //denominator je součástí výpočtu pro normalizaci těchto
        // barycentrických souřadnic (zajišťuje správnost)

        // Pokud jsou všechny hodnoty >= 0, bod je uvnitř trojúhelníku
        return a >= 0 && b >= 0 && c >= 0;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawPolygon(new int[] {position.x+ax, position.x+bx, (int) (position.x+cx)}, new int[] {position.y+ay, position.y+by,(int)(position.y+cy)}, 3);
    }

        @Override
        public void move(int dx, int dy) {
            position.translate(dx, dy);
        }

}
