package game.model.generator;

import game.model.Board;
import game.model.BoardField;
import game.model.Orientation;
import game.model.Turtle;

public class DataGenerator {
    private final static int boardSize = 5;
    private final static int[] visible = {10, 11, 12};

    static boolean arrContains(int[] arr, int key) {
        for (int i : arr)
            if (i == key) return true;
        return false;
    }

    public final static Board generateGameData() {
        Turtle turtle = new Turtle(0, 2, Orientation.E);
        BoardField[][] fields = new BoardField[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                fields[i][j] = arrContains(visible, i*boardSize+j) ?
                        new BoardField(true) : new BoardField(false);

        Board board = new Board(turtle, fields);
        return board;
    }
}
