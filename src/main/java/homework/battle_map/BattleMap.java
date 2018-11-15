package homework.battle_map;

import java.util.ArrayList;

/**
 *
 */
public class BattleMap extends  AbstractBattleMap{

    public BattleMap(){
        for (int index = 0; index < 10 ; index++) {
            map.add(new ArrayList<Character>());
            for (int i = 0; i <10 ; i++) {
                map.get(index).add('☐');
            }
        }
    }

    /**
     * display Battle map to console
     */
    public void display() {
        for (ArrayList list: map) {
            System.out.println(list);
        }
    }

    public ArrayList<ArrayList<Character>> getMap() {
        return map;
    }
}
