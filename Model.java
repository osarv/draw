import java.util.ArrayList;
import java.awt.Color;
import java.io.*;

class Model {
    Color color = Color.BLUE;
    Shape shape = Shape.RECT;
    private ArrayList<Geom> geoms;

    Model(ArrayList<Geom> geoms) {
        this.geoms = geoms;
    }

    public void PushGeom(Geom g) {
        geoms.add(g);
    }

    public void PopGeom() {
        if (geoms.size() == 0) return;
        geoms.remove(geoms.size() - 1);
    }

    public void UpdateLastGeom(Geom g) {
        if (geoms.size() == 0) return;
        geoms.set(geoms.size() - 1, g);
    }

    public void SetColor(Color c) {
        color = c;
    }

    public Color GetColor() {
        return color;
    }

    public Shape GetShape() {
        return shape;
    }

    public ArrayList<Geom> GetGeoms() {
        return geoms;
    }

    public void SaveModel(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
        }
        catch (IOException e) {}
    }

    public Model LoadModel(String path) {
        Model m = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            m = (Model)ois.readObject();
        }
        catch (Exception e) {}
        return m;
    }
}
