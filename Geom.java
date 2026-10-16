import java.awt.Color;

class Geom {
    public final int x;
    public final int y;
    public final int height;
    public final int width;
    public final Color color;
    public final Shape shape;

    Geom(int x, int y, int width, int height, Shape shape, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shape = shape;
        this.color = color;
    }
}
