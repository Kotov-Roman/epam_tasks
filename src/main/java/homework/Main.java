package homework;

import homework.battle_map.BattleMap;
import homework.ship.AbstractShip;
import homework.ship.ShipFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        SetShipsOnMapService service = new SetShipsOnMapService();
        service.getMapWithShips().display();
        ArrayList<AbstractShip> listOFShips = service.getInitialListOfShips();
        for (AbstractShip ship : listOFShips) {
            ArrayList<int[]> allCoordinates = ship.getAllCoordinates();
            System.out.println("ship length: "+ship.getLenght());
            for (int[] coordinates : allCoordinates) {
                System.out.println(Arrays.toString(coordinates));
            }
        }

    }
}





