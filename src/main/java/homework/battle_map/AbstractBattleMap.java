package homework.battle_map;

import java.util.ArrayList;

public abstract class AbstractBattleMap {

    ArrayList<ArrayList<Character>> map = new ArrayList<>();

    ArrayList<ArrayList<int []>> mapCoordinates = new ArrayList<>();

    public abstract void display();

    public ArrayList<ArrayList<Character>> getMap() {
        return map;
    }

    public ArrayList<ArrayList<int[]>> getMapCoordinates() {
        return mapCoordinates;
    }
}
