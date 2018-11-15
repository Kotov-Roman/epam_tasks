package homework;

import homework.battle_map.AbstractBattleMap;
import homework.battle_map.BattleMap;
import homework.ship.AbstractShip;

import java.util.ArrayList;

public class Player {
    SetShipsOnMapService playerSetShipsOnMapService = new SetShipsOnMapService();
    AbstractBattleMap playerRealMap = playerSetShipsOnMapService.getMapWithShips();
    ArrayList<AbstractShip> playerListOfShips = playerSetShipsOnMapService.getInitialListOfShips();

    AbstractBattleMap playerMapWithShoots = new BattleMap();

    ShootService playerShootService = new ShootService();
    ArrayList<int []> playerShootList = playerShootService.getShootList();
}
