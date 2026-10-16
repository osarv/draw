import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

class Controller extends MouseAdapter {
    Model model;
    View view;

    private boolean pressed;
    private int pressedX;
    private int pressedY;
    private int movedX;
    private int movedY;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.blueButton.addActionListener(p -> model.SetColor(Color.BLUE));
        view.redButton.addActionListener(p -> model.SetColor(Color.RED));
        view.blackButton.addActionListener(p -> model.SetColor(Color.BLACK));
    }

    private Geom createGeom() {
        Geom g = null;
        int x = Integer.min(pressedX, movedX);
        int y = Integer.min(pressedY, movedY);
        int width = Math.abs(pressedX - movedX);
        int height = Math.abs(pressedY - movedY);
        return new Geom(x, y, width, height, model.GetShape(), model.GetColor());
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        pressedX = e.getX();
        pressedY = e.getY();
        if (model.GetShape() == Shape.POINT) {
            model.PushGeom(new Geom(pressedX -5, pressedY - 5, 10, 10, Shape.POINT, model.GetColor()));
        }
        model.PushGeom(createGeom());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        movedX = e.getX();
        movedY = e.getY();
        model.UpdateLastGeom(createGeom());
        view.repaint();
    }
}
