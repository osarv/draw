import java.util.ArrayList;

class Model {
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
}
