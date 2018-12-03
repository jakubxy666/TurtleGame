package game.model;

public class Board {
    private Turtle turtle;
    private BoardField[][] fields;

    public Board(Turtle turtle, BoardField[][] fields) {
        this.turtle = turtle;
        this.fields = fields;
    }

    public Turtle getTurtle() {
        return turtle;
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    public BoardField[][] getFields() {
        return fields;
    }

    public void setFields(BoardField[][] fields) {
        this.fields = fields;
    }
}
