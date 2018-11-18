package homework;

import homework.battle_map.AbstractBattleMap;
import homework.battle_map.BattleMap;
import homework.ship.AbstractShip;

import java.util.ArrayList;

public class Player {
    SetShipsOnMapService playerSetShipsOnMapService = new SetShipsOnMapService();
    AbstractBattleMap playerRealMap = playerSetShipsOnMapService.getMapWithShips();
    AbstractBattleMap playerMapToDrowShoots = new BattleMap();
    ArrayList<AbstractShip> playerListOfShips = playerSetShipsOnMapService.getInitialListOfShips();
    ArrayList<String> playerShootList = new ArrayList<>();

    /**
     * поставить поле перед в самом начале что бы нормально рисовалось
     */
    ArrayList<AbstractShip> copyListOfShipsToDraw = new ArrayList<>();

    /**
     * @param copyListOfShipsToDraw вызвать вначале что бы рисовать
     */
    public void setCopyListOfShipsToDraw(ArrayList<AbstractShip> copyListOfShipsToDraw) {
        this.copyListOfShipsToDraw = new ArrayList<AbstractShip>(copyListOfShipsToDraw);
    }

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

        System.out.println("count of shoots: " + getPlayerShootList().size());// deeeeeeeeeeeelete this
        if (isShootHitTheDeck(coordinates, enemyListOfShips)) {
            System.out.println("Shoot hit the deck");
            drawHit(coordinates);
            return repeatTurn();
        } else {
            System.out.println("You missed");
            drawMiss(coordinates);
            return passTurnToComputer();
        }

        //return passTurnToComputer(); // 1 0 -1
    }


    public void drawMiss(String coordinates) {
        int x = Character.getNumericValue(coordinates.charAt(0));
        int y = Character.getNumericValue(coordinates.charAt(1));
        playerMapToDrowShoots.getMap().get(y).set(x, '✕');
    }
    public void drawHit(String coordinates) {
        int x = Character.getNumericValue(coordinates.charAt(0));
        int y = Character.getNumericValue(coordinates.charAt(1));
        playerMapToDrowShoots.getMap().get(y).set(x, '☒');
    }

    private boolean isShootHitTheDeck(String coordinates, ArrayList<AbstractShip> enemyListOfShips) {
        for (AbstractShip enemyShip : enemyListOfShips) {
            for (int[] deckCoordinates : enemyShip.getShipCoordinatesList()) {
                String shipCoordinates = deckCoordinates[0] + "" + deckCoordinates[1];
                if (shipCoordinates.equals(coordinates)) {/// отнимаем жизни корабля проверяем не убил ли, если убит - удаляем его из списка
                    enemyShip.shipLife--;
                    if (enemyShip.shipLife == 0) {
                        System.out.println("Ship killed");
                        enemyListOfShips.remove(enemyShip);
                        System.out.println("У противника осталось " + enemyListOfShips.size() + " кораблей");
                    }
                    return true;
                }
            }

        }
        return false;
    }

    public void killShip(ArrayList<AbstractShip> listOfEnemyShips, int[] shipCoordinates) {

    }

    public boolean isEnemyListOfShipsEmpty(ArrayList<AbstractShip> enemyListOfShips) {
        if (enemyListOfShips.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @param coordinates - player input
     * @return true if input is wrong. If everything is ok, return false
     */
    public boolean checkCoordinatesForWrongInput(String coordinates) {
        if (coordinates == "" || coordinates == null) {
            System.out.println("Null input");
            ;
            return true;
        }
        if (coordinates.length() != 2) {
            System.out.println("length wrong");
            return true;
        }
        int x = Character.getNumericValue(coordinates.charAt(0));
        int y = Character.getNumericValue(coordinates.charAt(1));
        boolean isX_Correct = (x < 10) & (x >= 0);
        boolean isY_Correct = (y < 10) & (y >= 0);
        if (isX_Correct & isY_Correct) {
            System.out.println("all right");
            return false;
        } else {
            System.out.println("wrong input");
            return true;
        }
    }

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

    private int finishGame() {
        return -1;
    }


    public ArrayList<AbstractShip> getPlayerListOfShips() {
        return playerListOfShips;
    }

    public ArrayList<String> getPlayerShootList() {
        return playerShootList;
    }
}
