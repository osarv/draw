abstract class Geom {
    private int x;
    private int y;
    private int height;
    private int width;
    private int[] rgb = new int[3];

    Geom(int x, int y, int width, int height, int[] rgb) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
