package homework;

import homework.battle_map.AbstractBattleMap;
import homework.ship.AbstractShip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Computer {

    private SetShipsOnMapService computerSetShipsOnMapService = new SetShipsOnMapService();
    AbstractBattleMap computerRealMap = computerSetShipsOnMapService.getMapWithShips();
    ArrayList<AbstractShip> computerListOfShips = computerSetShipsOnMapService.getInitialListOfShips();

    ArrayList<int[]> computerShootList = new ArrayList<>();
    private boolean isKilled = false;
    private boolean isHurted = false;

    private int[] computerShootCoordinatesToShow = new int[2];
    private boolean isAnyShipHurted = false;
    private int[] computerLastHit = new int[2];
    private int[] computerFirsHit = new int[2];
    private int direction = 1;

    Computer() {
    }

    /**
     * Computer's turn method
     *
     * @return 0 in case to pass turn or 1 in case to repeat turn
     */
    public int computerTurn(ArrayList<AbstractShip> playerListOfShips) {//  return 1 | 0 |
        return shootWithLogic(playerListOfShips);
    }

    /**
     * Computer's method with shoot logic
     *
     * @return 0 in case to pass turn or 1 in case to repeat turn
     */
    private int shootWithLogic(ArrayList<AbstractShip> playerListOfShips) {
        if (isAnyShipHurted) {
            return tryToKillShip(playerListOfShips);
        } else {
            int[] shootCoordinates = usualShootWithRepeatCheck();
            computerShootCoordinatesToShow = shootCoordinates;

            if (isShootHurtTheDeck(shootCoordinates, playerListOfShips)) {
                computerFirsHit = shootCoordinates;
                computerLastHit = shootCoordinates;
                isShipKilled(shootCoordinates, playerListOfShips);
                return repeatTurn();
            } else {
                return passTurnToPlayer();
            }
        }
    }

    /**
     * Computer's turn logic in case if player have any hurt ship.
     * Logic shoots near the hurt ship coordinates, attempting to kill it
     *
     * @return 0 in case to pass turn or 1 in case to repeat turn
     */
    private int tryToKillShip(ArrayList<AbstractShip> playerListOfShips) {
        int x = computerLastHit[0];
        int y = computerLastHit[1];
        if (direction == 1) {
            if (x - 1 >= 0 & isShootable(x - 1, y)) {
                usualShoot(x - 1, y);
                computerShootCoordinatesToShow = new int[]{x - 1, y};
                if (isShootHurtTheDeck(new int[]{x - 1, y}, playerListOfShips)) {
                    if (isShipKilled(new int[]{x - 1, y}, playerListOfShips)) {
                        isAnyShipHurted = false;
                        direction = 1;
                        return repeatTurn();
                    }
                    computerLastHit = new int[]{x - 1, y};
                    return repeatTurn();
                } else {
                    computerLastHit = computerFirsHit;
                    direction = 2;
                    return passTurnToPlayer();
                }
            } else {
                computerLastHit = computerFirsHit;
                direction = 2;
            }
        }
        if (direction == 2) {
            if (x + 1 < 10 & isShootable(x + 1, y)) {
                usualShoot(x + 1, y);
                computerShootCoordinatesToShow = new int[]{x + 1, y};
                if (isShootHurtTheDeck(new int[]{x + 1, y}, playerListOfShips)) {
                    if (isShipKilled(new int[]{x + 1, y}, playerListOfShips)) {
                        isAnyShipHurted = false;
                        direction = 1;
                        return repeatTurn();
                    }
                    computerLastHit = new int[]{x + 1, y};
                    return repeatTurn();
                } else {
                    computerLastHit = computerFirsHit;
                    direction = 3;
                    return passTurnToPlayer();
                }
            } else {
                computerLastHit = computerFirsHit;
                direction = 3;
            }
        }
        if (direction == 3) {
            if (y - 1 >= 0 & isShootable(x, y - 1)) {
                usualShoot(x, y - 1);
                computerShootCoordinatesToShow = new int[]{x, y - 1};
                if (isShootHurtTheDeck(new int[]{x, y - 1}, playerListOfShips)) {
                    if (isShipKilled(new int[]{x, y - 1}, playerListOfShips)) {
                        isAnyShipHurted = false;
                        direction = 1;
                        return repeatTurn();
                    }
                    computerLastHit = new int[]{x, y - 1};
                    return repeatTurn();
                } else {
                    computerLastHit = computerFirsHit;
                    direction = 4;
                    return passTurnToPlayer();
                }
            } else {
                computerLastHit = computerFirsHit;
                direction = 4;
            }
        }
        if (direction == 4) {
            if (y + 1 < 10 & isShootable(x, y + 1)) {
                usualShoot(x, y + 1);
                computerShootCoordinatesToShow = new int[]{x, y + 1};
                if (isShootHurtTheDeck(new int[]{x, y + 1}, playerListOfShips)) {
                    if (isShipKilled(new int[]{x, y + 1}, playerListOfShips)) {
                        isAnyShipHurted = false;
                        direction = 1;
                        return repeatTurn();
                    }
                    computerLastHit = new int[]{x, y + 1};
                    return repeatTurn();
                } else {
                    computerLastHit = computerFirsHit;
                    direction = 1;
                    return passTurnToPlayer();
                }
            } else {
                direction = 1;
                return passTurnToPlayer();
            }
        } else {
            return passTurnToPlayer();
        }
    }

    /**
     * Make usual computer shot and add it to shootList
     *
     * @param x coordinate
     * @param y coordinate
     */
    private void usualShoot(int x, int y) {
        getComputerShootList().add(new int[]{x, y});
    }

    /**
     * Check for sense to shoot at specified coordinates
     *
     * @param x coordinate
     * @param y coordinate
     * @return true if it have sense
     */
    private boolean isShootable(int x, int y) {
        for (int[] coordinatesFromList : getComputerShootList()) {
            if (Arrays.equals(coordinatesFromList, new int[]{x, y})) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if ship killed
     *
     * @return true if ship killed
     */
    private boolean isShipKilled(int[] computerShoot, ArrayList<AbstractShip> playerListOfShips) {
        for (AbstractShip playerShip : playerListOfShips) {
            for (int[] shipDeckCoordinates : playerShip.getShipCoordinatesList()) {
                if (Arrays.equals(shipDeckCoordinates, computerShoot)) {
                    if (playerShip.shipLife == 0) {
                        flagKilledShipArea(playerShip);
                        playerListOfShips.remove(playerShip);
                        isHurted = true;
                        isKilled = true;
                        isAnyShipHurted = false;
                        return true;
                    }
                }
            }
        }
        isAnyShipHurted = true;
        return false;
    }

    /**
     * Flag area of killed ship on map
     */
    private void flagKilledShipArea(AbstractShip enemyShip) {
        ArrayList<int[]> shipArea = new ArrayList<>();
        for (int[] coordinates : enemyShip.getAllCoordinatesList()) {
            ArrayList<int[]> listToadd = flagDeck(coordinates);
            shipArea.addAll(listToadd);
        }
        computerShootList.addAll(shipArea);
        ArrayList<int[]> listToAdd;
        listToAdd = useKostil(computerShootList);
        computerShootList = listToAdd;
    }

    /**
     * returns list with coordinates to flag as shooted
     *
     * @return list
     */
    private ArrayList<int[]> flagDeck(int[] coordinates) {
        return getInts(coordinates);
    }

    /**
     * returns list with coordinates to flag as shooted
     *
     * @return list
     */
    public static ArrayList<int[]> getInts(int[] coordinates) {
        ArrayList<int[]> listOfFlags = new ArrayList<>();
        int x = coordinates[0];
        int y = coordinates[1];
        int xHelper = -1;

        for (int i = 0; i < 3; i++) {
            int yHelper = -1;

            if (x + xHelper >= 0 & x + xHelper < 10) {

                for (int j = 0; j < 3; j++) {
                    if (y + yHelper >= 0 & y + yHelper < 10) {
                        listOfFlags.add(new int[]{x + xHelper, y + yHelper});
                    }
                    yHelper++;
                }
            }
            xHelper++;
        }
        return listOfFlags;
    }

    /**
     * Metgod helps to returns ArrayList with elements int [] wich are nt repeated
     *
     * @return list with unique elements
     */
    private ArrayList<int[]> useKostil(ArrayList<int[]> listToEdit) {
        ArrayList<String> listWithStrings = new ArrayList<>();
        for (int[] coordinates : listToEdit) {
            int x = coordinates[0];
            int y = coordinates[1];
            String s = x + "" + y;
            listWithStrings.add(s);
        }

        Set<String> set = new HashSet<>(listWithStrings);
        ArrayList<int[]> result = new ArrayList<>();
        for (String stringFromSet : set) {
            int[] arr = new int[2];
            arr[0] = Character.getNumericValue(stringFromSet.charAt(0));
            arr[1] = Character.getNumericValue(stringFromSet.charAt(1));
            result.add(arr);
        }
        return result;
    }

    /**
     * generate random shoot coordinates and check it for repeat
     *
     * @return array of coordinates which are nor repeated
     */
    private int[] usualShootWithRepeatCheck() {
        int[] usualShootCoordinates = new int[2];
        while (true) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            usualShootCoordinates[0] = x;
            usualShootCoordinates[1] = y;
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isUniqueShoot(usualShootCoordinates)) {
                break;
            }
        }
        computerShootList.add(usualShootCoordinates);
        return usualShootCoordinates;
    }

    /**
     * check of shoot damaged any deck
     *
     * @return true in case when ship damaged
     */
    private boolean isShootHurtTheDeck(int[] computerShoot, ArrayList<AbstractShip> playerListOfShips) {
        for (AbstractShip playerShip : playerListOfShips) {
            for (int[] shipDeckCoordinates : playerShip.getShipCoordinatesList()) {
                if (Arrays.equals(shipDeckCoordinates, computerShoot)) {
                    playerShip.shipLife--;
                    isHurted = true;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for shoot repeat
     *
     * @return true in case it is not repeated
     */
    private boolean isUniqueShoot(int[] shootCoordinates) {
        for (int[] shootFromList : getComputerShootList()) {
            if (Arrays.equals(shootCoordinates, shootFromList)) {
                return false;
            }
        }
        return true;
    }

    /**
     * displays shoot result
     */
    public void showLastShootCoordinates() {
        System.out.println("Computer's shoot coordinates : " + Arrays.toString(computerShootCoordinatesToShow));
        if (isKilled) {
            System.out.println("Ship is killed by computer");
            isKilled = false;
            isHurted = false;
        } else {
            if (isHurted) {
                System.out.println("Ship is damaged by computer");
                isHurted = false;
            } else {
                System.out.println("Computer missed");
            }

        }
    }

    private int passTurnToPlayer() {
        return 0;
    }

    private int repeatTurn() {
        return 1;
    }

    public ArrayList<AbstractShip> getComputerListOfShips() {
        return computerListOfShips;
    }

    private ArrayList<int[]> getComputerShootList() {
        return computerShootList;
    }

}
