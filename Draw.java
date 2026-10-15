import javax.swing.*;
import java.util.ArrayList;

class Draw {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MS Paint from Wish");
        Model mdl = new Model(new ArrayList<Geom>());
        View view = new View(mdl);
        Controller ctrlr = new Controller(mdl, view);
        view.addMouseListener(ctrlr);
        frame.add(view);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
