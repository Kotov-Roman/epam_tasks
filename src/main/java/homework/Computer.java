package homework;

import homework.battle_map.AbstractBattleMap;
import homework.ship.AbstractShip;

import java.util.ArrayList;
import java.util.Arrays;

public class Computer {

    SetShipsOnMapService computerSetShipsOnMapService = new SetShipsOnMapService();
    AbstractBattleMap computerRealMap = computerSetShipsOnMapService.getMapWithShips();
    ArrayList<AbstractShip> computerListOfShips = computerSetShipsOnMapService.getInitialListOfShips();

    ArrayList<int[]> computerShootList = new ArrayList<>();

    int[] computerLastShoot = new int[2];
    boolean isPreviousShootHurtDeck = false;
    boolean isAnyShipHurted = false;

    public int computerTurn(ArrayList<AbstractShip> playerListOfShips) {//  return 1 | 0 | -1
        return shootWithLogic(playerListOfShips);
    }


    /**
     * @param playerListOfShips
     * @return
     */
    public int shootWithLogic(ArrayList<AbstractShip> playerListOfShips) {
        if (isAnyShipHurted)//есть поврежеднный корабль?
        {
            System.out.println("HURTEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEDDDDDD");
            isAnyShipHurted = false;
            return repeatTurn();








        } else {
            int[] shootCoordinates = usualShootWithRepeatCheck();
            System.out.println("Shoot coordinates: " + Arrays.toString(shootCoordinates));
            System.out.println("count of shoots : " + getComputerShootList().size());

            if (isShootHurtTheDeck(shootCoordinates, playerListOfShips)) {
                isPreviousShootHurtDeck = true;
                isShipKilled(shootCoordinates, playerListOfShips);
                return repeatTurn();
            } else {
                isPreviousShootHurtDeck = false;
                return passTurnToPlayer();
            }
        }


    }

    public boolean isShipKilled(int[] computerShoot, ArrayList<AbstractShip> playerListOfShips){
        for (AbstractShip playerShip : playerListOfShips) {
            for (int[] shipDeckCoordinates : playerShip.getShipCoordinatesList()) {
                if (Arrays.equals(shipDeckCoordinates, computerShoot)) {
                    if (playerShip.shipLife ==0){
                        playerListOfShips.remove(playerShip);
                        isAnyShipHurted = false;
                        System.out.println("Your ship killed");
                        return true;
                    }
                }
            }
        }
        isAnyShipHurted = true;
        return false;
    }

    public int[] usualShootWithRepeatCheck() {
        int count = 1;
        int[] usualShootCoordinates = new int[2];
        while (true) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            usualShootCoordinates[0] = x;
            usualShootCoordinates[1] = y;
            System.out.println(" попытка выстрела компа :" + count);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if (isUniqueShoot(usualShootCoordinates)) {
                break;
            }
        }
        computerShootList.add(usualShootCoordinates);
        return usualShootCoordinates;
    }


    public boolean isShootHurtTheDeck(int[] computerShoot, ArrayList<AbstractShip> playerListOfShips) {
        for (AbstractShip playerShip : playerListOfShips) {
            for (int[] shipDeckCoordinates : playerShip.getShipCoordinatesList()) {
                if (Arrays.equals(shipDeckCoordinates, computerShoot)) {
                    playerShip.shipLife--;
                    System.out.println("ПОПААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААЛ");
                    System.out.println("ПОПААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААЛ");
                    isPreviousShootHurtDeck = true;
                    return true;
                }
            }
        }
        System.out.println("не попал");
        isPreviousShootHurtDeck = false;
        return false;
    }

    public boolean isUniqueShoot(int[] shootCoordinates) {
        for (int[] shootFromList : getComputerShootList()) {
            if (Arrays.equals(shootCoordinates, shootFromList)) {
                return false;
            }
        }
        return true;
    }

    private int passTurnToPlayer() {
        return 0;
    }

    private int repeatTurn() {
        return 1;
    }

    private int finishGame() {
        return -1;
    }

    public SetShipsOnMapService getComputerSetShipsOnMapService() {
        return computerSetShipsOnMapService;
    }

    public AbstractBattleMap getComputerRealMap() {
        return computerRealMap;
    }

    public ArrayList<AbstractShip> getComputerListOfShips() {
        return computerListOfShips;
    }

    public ArrayList<int[]> getComputerShootList() {
        return computerShootList;
    }

    public int[] getComputerLastShoot() {
        return computerLastShoot;
    }
}
