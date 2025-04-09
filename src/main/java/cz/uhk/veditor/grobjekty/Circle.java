package cz.uhk.veditor.grobjekty;

import java.awt.*;

public class Circle extends AbstractGeomObject {
    protected int radius;

    public Circle(Point position, int radius, Color color) {
        super(position, color);
        this.radius = radius;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean contains(int x, int y) {
        // Spočítáme střed kruhu
        int centerX = position.x + radius;
        int centerY = position.y + radius;

        // Spočítáme vzdálenost mezi bodem (x, y) a středem kruhu
        int dx = x - centerX;
        int dy = y - centerY;

        // Pokud je vzdálenost menší nebo rovna poloměru, je bod uvnitř
        int distanceSquared = dx * dx + dy * dy;
        return distanceSquared <= radius * radius;    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawOval(position.x, position.y, 2*radius, 2*radius);
    }

    @Override
    public void move(int dx, int dy) {
        position.translate(dx, dy);
    }
}
