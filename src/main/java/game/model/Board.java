package game.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

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

    public Boolean canMoveTo(int x, int y){
        return (x >= 0 && x < 5 && y >= 0 && y < 5 && fields[y][x].isVisible());
    }

    public void visitField(int x, int y){
        fields[y][x].setVisited(true);
    }

    public Boolean allVisited(){
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (fields[i][j].isVisible() && !fields[i][j].isVisited())
                    return false;
            }
        }
        return true;
    }
}
