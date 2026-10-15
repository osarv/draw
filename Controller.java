import javax.swing.*;
import java.awt.event.*;

enum Color {
    RED,
    BLACK,
    BLUE
};

enum Shape {
    RECT,
    OVAL
};

class Controller extends MouseAdapter {
    Model model;
    View view;

    Color color;
    Shape shape;
    private boolean pressed;
    private int pressedX;
    private int pressedY;
    private int movedX;
    private int movedY;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    private int[] getRgb(Color color) {
        switch(color) {
            case Color.RED: return new rgb[] {255, 0, 0};
            case Color.BLACK: return new rgb[] {255, 255, 255};
            case Color.BLUE: return new rgb[] {0, 0, 255};
        }
    }

    private Geom createGeom() {
        Geom g;
        int x = Integer.min(pressedX, movedX);
        int y = Integer.min(pressedY, movedY);
        int width = Math.abs(pressedX - movedX);
        int height = Math.abs(pressedY - movedY);
        switch (shape) {
            case Shape.RECT: g = Rect(x, y, width, height, rgb);
            case Shape.OVAL: g = Oval(x, y, width, height);
        }
        return g;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        PressedX = e.getX();
        PressedY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        PushGeom(createGeom());
        view.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (!pressed) return;
        movedX = e.getX();
        movedY = e.getY();
        PushGeom(createGeom());
        PopGeom();
    }
}
