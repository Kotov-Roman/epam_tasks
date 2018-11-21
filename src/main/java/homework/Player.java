package homework;

import homework.battle_map.AbstractBattleMap;
import homework.battle_map.BattleMap;
import homework.ship.AbstractShip;

import java.util.ArrayList;

public class Player {
    private SetShipsOnMapService playerSetShipsOnMapService = new SetShipsOnMapService();
    AbstractBattleMap playerRealMap = playerSetShipsOnMapService.getMapWithShips();
    AbstractBattleMap playerMapToDrowShoots = new BattleMap();
    private ArrayList<AbstractShip> playerListOfShips = playerSetShipsOnMapService.getInitialListOfShips();
    ArrayList<String> playerShootList = new ArrayList<>();
    private AbstractShip lastKilledShip = null;
    private boolean justKilledShip = false;


    /**
     * Main method which implements player turn logic.
     *
     * @param coordinates      - player input
     * @param enemyListOfShips - list to check shooting
     * @return -1 - case when need to finish game and show results
     */
    public int playerMainTurn(String coordinates, ArrayList<AbstractShip> enemyListOfShips) {
        if (checkCoordinatesForWrongInput(coordinates)) {
            return repeatTurn();
        }
        if (isCoordinatesRepeat(coordinates)) {
            System.out.println("You already shoot here. Choose another direction");
            return repeatTurn();
        }
        addCoordinatesToShootList(coordinates);

        if (isShootHitTheDeck(coordinates, enemyListOfShips)) {
            if (justKilledShip) {
                System.out.println("Ship was killed");
                System.out.println(enemyListOfShips.size() + " ships left to destroy");
                justKilledShip = false;
            } else {
                System.out.println("Shoot hit the deck");
            }
            drawHit(coordinates);
            return repeatTurn();
        } else {
            System.out.println("You missed");
            drawMiss(coordinates);
            return passTurnToComputer();
        }
    }

    /**
     * displays miss on map
     */
    private void drawMiss(String coordinates) {
        int x = Character.getNumericValue(coordinates.charAt(0));
        int y = Character.getNumericValue(coordinates.charAt(1));
        playerMapToDrowShoots.getMap().get(y).set(x, '✕');
    }

    /**
     * displays shoot on map
     */
    private void drawHit(String coordinates) {
        int x = Character.getNumericValue(coordinates.charAt(0));
        int y = Character.getNumericValue(coordinates.charAt(1));
        playerMapToDrowShoots.getMap().get(y).set(x, '☒');
    }

    /**
     * check if shoot hit the deck
     *
     * @return false in case when did not hurt
     */
    private boolean isShootHitTheDeck(String coordinates, ArrayList<AbstractShip> enemyListOfShips) {
        for (AbstractShip enemyShip : enemyListOfShips) {
            for (int[] deckCoordinates : enemyShip.getShipCoordinatesList()) {
                String shipCoordinates = deckCoordinates[0] + "" + deckCoordinates[1];
                if (shipCoordinates.equals(coordinates)) {
                    enemyShip.shipLife--;
                    if (enemyShip.shipLife == 0) {
                        lastKilledShip = enemyShip;
                        drawKilledShip();
                        justKilledShip = true;
                        enemyListOfShips.remove(enemyShip);
                    }
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * displays killed ship and area around on map
     */
    private void drawKilledShip() {
        ArrayList<int[]> shipArea = new ArrayList<>();
        for (int[] coordinates : lastKilledShip.getAllCoordinatesList()) {
            ArrayList<int[]> listToadd = flagDeck(coordinates);
            shipArea.addAll(listToadd);
        }
        for (int[] coordinates : shipArea) {
            int x = coordinates[0];
            int y = coordinates[1];
            if (playerMapToDrowShoots.getMap().get(y).get(x).equals('☐')) {
                drawMiss(x + "" + y);
            }
            if (playerMapToDrowShoots.getMap().get(y).get(x).equals('■')) {
                drawHit(x + "" + y);
            }
        }
    }

    /**
     * returns list with coordinates to flag as shooted
     *
     * @return list
     */
    private ArrayList<int[]> flagDeck(int[] coordinates) {
        return Computer.getInts(coordinates);
    }

    /**
     * @param coordinates - player input
     * @return true if input is wrong. If everything is ok, return false
     */
    private boolean checkCoordinatesForWrongInput(String coordinates) {
        if (coordinates.equals("")) {
            System.out.println("Null input. Repeat turn");
            return true;
        }
        if (coordinates.length() != 2) {
            System.out.println("Wrong input. Repeat turn");
            return true;
        }
        int x = Character.getNumericValue(coordinates.charAt(0));
        int y = Character.getNumericValue(coordinates.charAt(1));
        boolean isX_Correct = (x < 10) & (x >= 0);
        boolean isY_Correct = (y < 10) & (y >= 0);
        if (isX_Correct & isY_Correct) {
            return false;
        } else {
            System.out.println("Wrong input. Repeat turn");
            return true;
        }
    }

    /**
     * check if coordinates for repeat
     *
     * @return true in case not repeated
     */
    private boolean isCoordinatesRepeat(String coordinates) {
        for (String shootFromList : getPlayerShootList()) {
            if (shootFromList.equals(coordinates)) {
                return true;
            }
        }
        return false;
    }

    private void addCoordinatesToShootList(String coordinates) {
        getPlayerShootList().add(coordinates);
    }

    private int passTurnToComputer() {
        return 1;
    }

    private int repeatTurn() {
        return 0;
    }

    public ArrayList<AbstractShip> getPlayerListOfShips() {
        return playerListOfShips;
    }

    private ArrayList<String> getPlayerShootList() {
        return playerShootList;
    }
}
