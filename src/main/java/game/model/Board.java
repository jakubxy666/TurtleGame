package game.model;

import java.util.List;

public class Board {
    private int boardSize;
    private Turtle turtle;
    private BoardField[][] fields;

    public Board(int boardSize, Turtle turtle, List fieldsInfo) {
        this.boardSize = boardSize;
        this.turtle = turtle;

        BoardField[][] fields = new BoardField[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++)
                fields[i][j] = (((List)fieldsInfo.get(i)).get(j)).toString().charAt(0) == '#' ?
                        new BoardField(true) : new BoardField(false);
        }

        fields[turtle.getY()][turtle.getX()].setVisited(true);
        this.fields = fields;
    }

    public int getBoardSize() {
        return boardSize;
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

