package homework;

import homework.battle_map.AbstractBattleMap;
import homework.ship.AbstractShip;

import java.util.ArrayList;

public class Computer {
    SetShipsOnMapService computerSetShipsOnMapService = new SetShipsOnMapService();
    AbstractBattleMap computerRealMap = computerSetShipsOnMapService.getMapWithShips();
    ArrayList<AbstractShip> computerListOfShips = computerSetShipsOnMapService.getInitialListOfShips();

    ShootService computerShootService = new ShootService();
    ArrayList<int []> computerShootList = computerShootService.getShootList();
}
