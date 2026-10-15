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
        int[] rgb = null;
        switch(color) {
            case Color.RED: rgb = new int[] {255, 0, 0};
            case Color.BLACK: rgb = new int[] {255, 255, 255};
            case Color.BLUE: rgb = new int[] {0, 0, 255};
        }
        return rgb;
    }

    private Geom createGeom() {
        Geom g = null;
        int x = Integer.min(pressedX, movedX);
        int y = Integer.min(pressedY, movedY);
        int width = Math.abs(pressedX - movedX);
        int height = Math.abs(pressedY - movedY);
        int[] rgb = getRgb(color);
        switch (shape) {
            case Shape.RECT: g = new Rect(x, y, width, height, rgb);
            case Shape.OVAL: g = new Oval(x, y, width, height, rgb);
        }
        return g;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        pressedX = e.getX();
        pressedY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        model.PushGeom(createGeom());
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
        model.PushGeom(createGeom());
        model.PopGeom();
    }
}
