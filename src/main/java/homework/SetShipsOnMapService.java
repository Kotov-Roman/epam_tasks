package homework;

import homework.battle_map.AbstractBattleMap;
import homework.battle_map.BattleMap;
import homework.ship.AbstractShip;
import homework.ship.ShipFactory;

import java.util.ArrayList;

public class SetShipsOnMapService {
    AbstractBattleMap initialBattleMap = new BattleMap();
    ShipFactory factory = new ShipFactory();
    ArrayList<AbstractShip> initialListOfShips = new ArrayList<>(10);


    public AbstractBattleMap getMapWithShips() {
        createInitialListOfShips();
        for (AbstractShip shipToSet: initialListOfShips) {
            findPlaceAndSetShip(shipToSet);
            shipToSet.setIntermediateCoordinates();
            shipToSet.setCoordinatesList();
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

    public boolean findPlaceAndSetShip(AbstractShip shipToSet) {
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
