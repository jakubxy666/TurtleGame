package game.model;

import javafx.beans.property.*;
import javafx.beans.value.ObservableIntegerValue;

public class Turtle {
    private IntegerProperty x;
    private IntegerProperty y;
    private ObjectProperty<Orientation> orientation;

    public Turtle(int x, int y, Orientation orientation) {
        this.x= new SimpleIntegerProperty(x);
        this.y=new SimpleIntegerProperty(y);

        this.orientation = new SimpleObjectProperty<Orientation>(orientation);
    }

    public int getX() {
        return x.getValue();
    }

    public IntegerProperty getXProperty() {
        return x;
    }

    public void setXProperty(IntegerProperty x) {
        this.x = x;
    }

    public void setX(int x) {
        this.x.setValue(x);
    }

    public IntegerProperty getYProperty() {
        return y;
    }

    public void setYProperty(IntegerProperty y) {
        this.y = y;
    }

    public int getY() {
        return y.getValue();
    }

    public void setY(int y) {
        this.y.setValue(y);
    }

    public ObjectProperty<Orientation> getOrientationProperty() {
        return orientation;
    }

    public void setOrientationProperty(ObjectProperty<Orientation> orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation.getValue();
    }

    public void setOrientation(Orientation orientation) {
        this.orientation.setValue(orientation);
    }
}
