package homework.battle_map;

import java.util.ArrayList;

/**
 *
 */
public class BattleMap extends AbstractBattleMap {

    public BattleMap() {
        for (int index = 0; index < 10; index++) {
            map.add(new ArrayList<Character>());
            for (int i = 0; i < 10; i++) {
                map.get(index).add('☐');
            }
        }
    }

    /**
     * display Battle map to console
     */
    public void display() {
        for (int i = 0; i < 10; i++) {
            if (i != 2 & i != 3 &  i != 6 & i != 7 & i != 9) {
                System.out.printf("%5s", i);
            } else {
                System.out.printf("%4s", i);
            }
        }
        System.out.printf("%4s", 'X');
        System.out.println();
        System.out.println();
        for (int i = 0; i < 10; i++) {
            ArrayList<Character> arrayList = map.get(i);
            System.out.print(i);
            for (Character character : arrayList) {
                System.out.printf("%4c", character);
            }
            System.out.println();
        }
        System.out.println("Y");
        System.out.println();
    }

    public ArrayList<ArrayList<Character>> getMap() {
        return map;
    }
}
