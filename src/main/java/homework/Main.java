package homework;

import homework.battle_map.EnemyBattleMap;
import homework.ship.AbstractShip;
import homework.ship.ShipFactory;

public class Main {
    public static void main(String[] args) {

        EnemyBattleMap map = new EnemyBattleMap();
        map.display();
        AbstractShip ship = new ShipFactory().createShip(1);
        AbstractShip ship2 = new ShipFactory().createShip(2);
        AbstractShip ship3 = new ShipFactory().createShip(3);
        AbstractShip ship4 = new ShipFactory().createShip(4);
        System.out.println(ship);
        System.out.println(ship2);
        System.out.println(ship3);
        System.out.println(ship4);
        BattleSetShipsOnMapService service = new BattleSetShipsOnMapService();
        for (int i = 0; i <20 ; i++) {
            System.out.println(service.getRandomStartSetPoint(ship3));

        }

    }
}





