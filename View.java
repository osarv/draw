import javax.swing.*;
import java.awt.Graphics;

class View extends JPanel {
    public JButton blueButton = new JButton("Blue");
    public JButton redButton = new JButton("Red");
    public JButton blackButton = new JButton("Black");
    public JButton rectButton = new JButton("Rect");
    public JButton ovalButton = new JButton("Oval");
    public JButton pointButton = new JButton("Point");

    Model model;
    View(Model model){
        this.model = model;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.add(blueButton);
        this.add(redButton);
        this.add(blackButton);
        for (Geom geom : model.GetGeoms()) {
            g.setColor(geom.color);
            switch (geom.shape) {
                case Shape.RECT: g.fillRect(geom.x, geom.y, geom.width, geom.height); break;
                case Shape.OVAL: g.fillOval(geom.x, geom.y, geom.width, geom.height); break;
                case Shape.POINT: g.fillOval(geom.x, geom.y, geom.width, geom.height); break;
            }
        }
    }
}
