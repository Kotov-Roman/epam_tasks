package homework;

import homework.battle_map.AbstractBattleMap;
import homework.battle_map.EnemyBattleMap;
import homework.ship.AbstractShip;
import homework.ship.ShipFactory;

import java.util.ArrayList;

public class BattleSetShipsOnMapService {
    AbstractBattleMap initialBattleMap = new EnemyBattleMap();
    ShipFactory factory = new ShipFactory();
    ArrayList<AbstractShip> initialListOfShips = new ArrayList<>(10);


    public AbstractBattleMap getMapWithShips() {
        createInitialListOfShips();
        for (AbstractShip shipToSet: initialListOfShips) {
            findPlaceAndSetShip(shipToSet);
        }
        return initialBattleMap;
    }

    public ArrayList<AbstractShip> getInitialListOfShips() {
        return initialListOfShips;
    }

    public ArrayList<AbstractShip> createInitialListOfShips(){
        initialListOfShips.add(factory.createShip(4));
        initialListOfShips.add(factory.createShip(3));
        initialListOfShips.add(factory.createShip(3));
        initialListOfShips.add(factory.createShip(2));
        initialListOfShips.add(factory.createShip(2));
        initialListOfShips.add(factory.createShip(2));
        initialListOfShips.add(factory.createShip(1));
        initialListOfShips.add(factory.createShip(1));
        initialListOfShips.add(factory.createShip(1));
        initialListOfShips.add(factory.createShip(1));
        return initialListOfShips;
    }



/*    public static void main(String[] args) {

        BattleSetShipsOnMapService battleSetShipsOnMapService = new BattleSetShipsOnMapService();
        battleSetShipsOnMapService.initialBattleMap.display();
        AbstractShip littleShip1 = factory.createShip(1);
        AbstractShip littleShip2 = factory.createShip(1);
        AbstractShip littleShip3 = new ShipFactory().createShip(1);
        AbstractShip littleShip4 = new ShipFactory().createShip(1);
        AbstractShip twoDecksShip1 = new ShipFactory().createShip(2);
        AbstractShip twoDecksShip2 = new ShipFactory().createShip(2);
        AbstractShip twoDecksShip3 = new ShipFactory().createShip(2);
        AbstractShip threeDecksShip1 = new ShipFactory().createShip(3);
        AbstractShip threeDecksShip2 = new ShipFactory().createShip(3);
        AbstractShip fourDecksShip = new ShipFactory().createShip(4);
        battleSetShipsOnMapService.findPlaceAndSetShip(littleShip1);
        battleSetShipsOnMapService.findPlaceAndSetShip(littleShip2);
        battleSetShipsOnMapService.findPlaceAndSetShip(littleShip3);
        battleSetShipsOnMapService.findPlaceAndSetShip(littleShip4);
        battleSetShipsOnMapService.findPlaceAndSetShip(twoDecksShip1);
        battleSetShipsOnMapService.findPlaceAndSetShip(twoDecksShip2);
        battleSetShipsOnMapService.findPlaceAndSetShip(twoDecksShip3);
        battleSetShipsOnMapService.findPlaceAndSetShip(threeDecksShip1);
        battleSetShipsOnMapService.findPlaceAndSetShip(threeDecksShip2);
        battleSetShipsOnMapService.findPlaceAndSetShip(fourDecksShip);
        System.out.println("space");
        System.out.println("space");
        battleSetShipsOnMapService.initialBattleMap.display();
        System.out.println("threeDecksShip1 : " + threeDecksShip1.getCoordinates());
        System.out.println("threeDecksShip2 : " + threeDecksShip2.getCoordinates());
        System.out.println("fourDecksShip : " + fourDecksShip.getCoordinates());

    }*/

    public boolean findPlaceAndSetShip(AbstractShip shipToSet) {
        // выбрать направление пока что только Х после решить какое будет иметь getRandomStartSetPoint(shipToSet)
        while (true) {
            double direction = chooseDirection();
            if (direction < 0.5) {
                int randomX = getRandomStartSetPoint(shipToSet);
                int randomY = (int) (Math.random() * 10);
                if (checkAreaToSetLineX(randomX, randomY, shipToSet)) {
                    setShipOnLine_X(randomX, randomY, shipToSet);
                    break;
                }
            } else {
                int randomX = (int) (Math.random() * 10);
                int randomY = getRandomStartSetPoint(shipToSet);
                if (checkAreaToSetLineY(randomX, randomY, shipToSet)) {
                    setShipOnLine_Y(randomX, randomY, shipToSet);
                    break;
                }

            }
        }
        return true;
    }

    public boolean checkAreaToSetLineX(int x, int y, AbstractShip shipToSet) {

        ArrayList<Integer> listToCheck_Y = new ArrayList<>(3);
        Integer yPotentialToCheck = y - 1;
        for (int i = 0; i < 3; i++) {
            if (yPotentialToCheck >= 0 & yPotentialToCheck < 10) {
                listToCheck_Y.add(yPotentialToCheck);
            }
            yPotentialToCheck++;
        }

        ArrayList<Integer> listToCheck_X = new ArrayList<>(3);
        Integer xPotentialToCheck = x - 1;
        for (int i = 0; i < shipToSet.getLenght() + 2; i++) {
            if (xPotentialToCheck >= 0 & xPotentialToCheck < 10) {
                listToCheck_X.add(xPotentialToCheck);
            }
            xPotentialToCheck++;
        }
        boolean result = helpCheckArea(listToCheck_Y, listToCheck_X);
        return result;
    }

    public boolean checkAreaToSetLineY(int x, int y, AbstractShip shipToSet) {
        ArrayList<Integer> listToCheck_X = new ArrayList<>(3);
        Integer xPotentialToCheck = x - 1;
        for (int i = 0; i < 3; i++) {
            if (xPotentialToCheck >= 0 & xPotentialToCheck < 10) {
                listToCheck_X.add(xPotentialToCheck);
            }
            xPotentialToCheck++;
        }

        ArrayList<Integer> listToCheck_Y = new ArrayList<>(3);
        Integer yPotentialToCheck = y - 1;
        for (int i = 0; i < shipToSet.getLenght() + 2; i++) {
            if (yPotentialToCheck >= 0 & yPotentialToCheck < 10) {
                listToCheck_Y.add(yPotentialToCheck);
            }
            yPotentialToCheck++;
        }
        return helpCheckArea(listToCheck_Y, listToCheck_X);
    }

    private boolean helpCheckArea(ArrayList<Integer> listToCheck_Y, ArrayList<Integer> listToCheck_X) {
        for (Integer checkingY : listToCheck_Y) {
            for (Integer checkingX : listToCheck_X) {
                if (getMapLine(checkingY).get(checkingX).equals('■')) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setShipOnLine_X(int x, int y, AbstractShip shipToSet) {
        int shipLength = shipToSet.getLenght();
        for (int index_X = x; index_X < x + shipLength; index_X++) {
            getMapLine(y).set(index_X, '■');
        }
        shipToSet.setxFrontSideShipPosition(x);
        shipToSet.setyFrontSideShipPosition(y);
        shipToSet.setxBacksideShipPosition(x + shipLength - 1);
        shipToSet.setyBacksideShipPosition(y);
    }

    public void setShipOnLine_Y(int x, int y, AbstractShip shipToSet) {
        int shipLength = shipToSet.getLenght();
        for (int index_Y = y; index_Y < y + shipLength; index_Y++) {
            getMapLine(index_Y).set(x, '■');
        }
        shipToSet.setxFrontSideShipPosition(x);
        shipToSet.setyFrontSideShipPosition(y);
        shipToSet.setxBacksideShipPosition(x);
        shipToSet.setyBacksideShipPosition(y + shipLength - 1);
    }

    private ArrayList<Character> getMapLine(int y) {
        return initialBattleMap.getMap().get(y);
    }

    /**
     * @param ship - current ship to set on map
     * @return initial number of cell to set ship includes bound ( <10-ship.length)
     */
    public int getRandomStartSetPoint(AbstractShip ship) {
        int randomStartSetPoint = (int) (Math.random() * 10);
        while (randomStartSetPoint + ship.getLenght() > 10) {
            randomStartSetPoint--;
        }
        return randomStartSetPoint;
    }

    /**
     * @return number. If number < 0.5, direction would be OX, else : OY
     */
    private double chooseDirection() {
        return Math.random();
    }


}
/*    EnemyBattleMap initialBattleMap = EnemyBattleMap.createBigMap();

 *//**
 * @param targetBattleMap
 * @param shipToSet
 * @return
 * @param targetBattleMap
 * @param shipToSet
 * @param targetBattleMap
 * @param shipToSet
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 * @param targetBattleMap
 * @param shipToSet
 * @param targetBattleMap
 * @param shipToSet
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 * @param targetBattleMap
 * @param shipToSet
 * @param targetBattleMap
 * @param shipToSet
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 * @param targetBattleMap
 * @param shipToSet
 * @param targetBattleMap
 * @param shipToSet
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 * @param targetBattleMap
 * @param shipToSet
 * @param targetBattleMap
 * @param shipToSet
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 * @param targetBattleMap
 * @param shipToSet
 * @param targetBattleMap
 * @param shipToSet
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 * @param targetBattleMap
 * @param shipToSet
 * @param targetBattleMap
 * @param shipToSet
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 * @param targetBattleMap
 * @param shipToSet
 * @param targetBattleMap
 * @param shipToSet
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 * @param targetBattleMap
 * @param shipToSet
 * @param targetBattleMap
 * @param shipToSet
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 * @param targetBattleMap
 * @param shipToSet
 * @param targetBattleMap
 * @param shipToSet
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 *//*
    public EnemyBattleMap setShipOnMap(EnemyBattleMap targetBattleMap, Ship shipToSet) {
        double randomDirection = Math.random(); //Math.random();  // допилить рандомизацию

        if (randomDirection < 0.5) {
            setShipOnLine_X(targetBattleMap, shipToSet);
        } else {
            setShipOnLine_Y(targetBattleMap, shipToSet);
        }
        return targetBattleMap; // нужно создать копию массива и работать в ней и потом ее возвращать при необходиомтсти либо делать изменения осторожно в этой же карте
    }

    *//**
 * @param targetBattleMap
 * @param shipToSet
 *//*
    public void setShipOnLine_X (EnemyBattleMap targetBattleMap, Ship shipToSet){
        int shipSize = shipToSet.getShipLength();
        Character[] targetLineToSet = targetBattleMap.getMap()[(int) (Math.random() * 10)]; // set ship on line x
        int randomStartSetPoint = getRandomStartSetPoint(shipToSet);
        int shipCellIndex = 0;

        for (int index_X = randomStartSetPoint; index_X < randomStartSetPoint + shipSize; index_X++) {
            targetLineToSet[index_X] = shipToSet.getShip()[shipCellIndex];
            shipCellIndex++;
        }
    }

    *//**
 * @param targetBattleMap
 * @param shipToSet
 *//*
    public void setShipOnLine_Y (EnemyBattleMap targetBattleMap, Ship shipToSet){
        int shipSize = shipToSet.getShipLength();
        int randomColumnX = (int) (Math.random() * 10);
        int randomColumnY = getRandomStartSetPoint(shipToSet);
        int initialPosition_Y = randomColumnY;
        int shipCellIndex = 0;

        for (int index_Y = randomColumnY; index_Y < randomColumnY + shipSize; index_Y++) {
            targetBattleMap.getMap()[initialPosition_Y][randomColumnX] = shipToSet.getShip()[shipCellIndex];
            shipCellIndex++;
            initialPosition_Y++;
        }
    }

    *//**
 * @param ship - current ship to set on map
 * @return initial number of cell to set ship
 *//*
    public int getRandomStartSetPoint(Ship ship) {
        int randomStartSetPoint = (int) (Math.random() * 10);
        while (randomStartSetPoint + ship.getShipLength() > 10) {
            randomStartSetPoint--;
        }
        return randomStartSetPoint;
    }

    public boolean checkZoneLine_X(int x, int y, Ship shipToSet){
        boolean check = true;
        for ()

    }*/
