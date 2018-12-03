package game.model.generator;

import game.model.Board;
import game.model.Orientation;
import game.model.Turtle;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class DataGenerator {

    public final static Board generateGameData() {
        String strJSON = "";
        try {
            strJSON = new String(Files.readAllBytes(Paths.get("./src/main/resources/levels/lvl2.json")));
        } catch (IOException e) { System.out.println(e); }

        JSONObject lvlJSON = new JSONObject(strJSON);

        int boardSize = lvlJSON.getInt("boardSize");
        int turtleX = lvlJSON.getInt("turtleX");
        int turtleY = lvlJSON.getInt("turtleY");
        String turtleOrientation = lvlJSON.getString("turtleOrientation");

        JSONArray fieldsInfoJSON = lvlJSON.getJSONArray("fieldsInfo");
        List fieldsInfo = fieldsInfoJSON.toList();

        Turtle turtle = new Turtle(turtleX, turtleY, Orientation.valueOf(turtleOrientation));

        return new Board(boardSize, turtle, fieldsInfo);
    }

}