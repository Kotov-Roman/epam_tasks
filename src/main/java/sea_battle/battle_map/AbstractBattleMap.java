package sea_battle.battle_map;

import java.util.ArrayList;

public abstract class AbstractBattleMap {

    ArrayList<ArrayList<Character>> map = new ArrayList<>();

    public abstract void display();

    public ArrayList<ArrayList<Character>> getMap() {
        return map;
    }

}
