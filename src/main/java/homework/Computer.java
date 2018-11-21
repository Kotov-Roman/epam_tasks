package homework;

import homework.battle_map.AbstractBattleMap;
import homework.ship.AbstractShip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Computer {

    SetShipsOnMapService computerSetShipsOnMapService = new SetShipsOnMapService();
    AbstractBattleMap computerRealMap = computerSetShipsOnMapService.getMapWithShips();
    ArrayList<AbstractShip> computerListOfShips = computerSetShipsOnMapService.getInitialListOfShips();

    ArrayList<int[]> computerShootList = new ArrayList<>();
    boolean iskilled = false;
    boolean isHurted = false;

    int[] computerShootCoordinatesToShow = new int[2];
    boolean isPreviousShootHurtDeck = false;
    boolean isAnyShipHurted = false;
    int[] computerLastHit = new int[2];
    int[] computerFirsHit = new int[2];
    int direction = 1;

    public int computerTurn(ArrayList<AbstractShip> playerListOfShips) {//  return 1 | 0 |
        return shootWithLogic(playerListOfShips);
    }


    /**
     * @param playerListOfShips
     * @return
     */
    public int shootWithLogic(ArrayList<AbstractShip> playerListOfShips) {
        if (isAnyShipHurted) {
            return tryTokillShip(playerListOfShips);
        } else {
            int[] shootCoordinates = usualShootWithRepeatCheck();
            computerShootCoordinatesToShow = shootCoordinates;

            if (isShootHurtTheDeck(shootCoordinates, playerListOfShips)) {
                isPreviousShootHurtDeck = true;
                computerFirsHit = shootCoordinates;
                computerLastHit = shootCoordinates;
                isShipKilled(shootCoordinates, playerListOfShips);
                return repeatTurn();
            } else {
                isPreviousShootHurtDeck = false;
                return passTurnToPlayer();
            }
        }
    }

    public int tryTokillShip(ArrayList<AbstractShip> playerListOfShips) {
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

    void usualShoot(int x, int y) {
        getComputerShootList().add(new int[]{x, y});
        //System.out.println("Координаты выстрела из попытки добивания: " + x + " " + y);
    }

    boolean isShootable(int x, int y) {
        for (int[] coordinatesFromList : getComputerShootList()) {
            if (Arrays.equals(coordinatesFromList, new int[]{x, y})) {
                return false;
            }
        }
        return true;
    }


    public boolean isShipKilled(int[] computerShoot, ArrayList<AbstractShip> playerListOfShips) {
        for (AbstractShip playerShip : playerListOfShips) {
            for (int[] shipDeckCoordinates : playerShip.getShipCoordinatesList()) {
                if (Arrays.equals(shipDeckCoordinates, computerShoot)) {
                    if (playerShip.shipLife == 0) {
                        flagKilledShipArea(playerShip);/////////////////////////////asasfafasfasfasfa
                        playerListOfShips.remove(playerShip);
                        isHurted = true;
                        iskilled = true;
                        isAnyShipHurted = false;
                        return true;
                    }
                }
            }
        }

        isAnyShipHurted = true;
        return false;
    }

    public void flagKilledShipArea(AbstractShip enemyShip) {
        ArrayList<int[]> shipArea = new ArrayList<>();
        for (int[] coordinates : enemyShip.getAllCoordinatesList()) {
            ArrayList<int[]> listToadd = flagDeck(coordinates);
            shipArea.addAll(listToadd);
        }
        //System.out.println(shipArea.size() + " размер плоащади добавления");


       // int size = computerShootList.size();
        //System.out.println(size + " размер списка выстрелов");

        computerShootList.addAll(shipArea);
        ArrayList<int[]> listToAdd = new ArrayList<>();
        listToAdd = useKostil(computerShootList);
        computerShootList = listToAdd;


    }

    public ArrayList<int[]> flagDeck(int[] coordinates) {
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

    public ArrayList<int[]> useKostil(ArrayList<int[]> listToEdit) {
        ArrayList<String> listWithStrings = new ArrayList<>();
        int index = 0;
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


    public int[] usualShootWithRepeatCheck() {
        int count = 1;
        int[] usualShootCoordinates = new int[2];
        while (true) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            usualShootCoordinates[0] = x;
            usualShootCoordinates[1] = y;
            //System.out.println(" попытка выстрела компа :" + count);
            try {
                Thread.sleep(2);
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
                    //System.out.println("ПОПААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААЛ");
                    //System.out.println("ПОПААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААЛ");
                    isPreviousShootHurtDeck = true;
                    isHurted = true;
                    return true;
                }
            }
        }
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
    public void showLastShootCoordinates(){
        System.out.println("Computer's shoot coordinates : " + Arrays.toString(computerShootCoordinatesToShow));
        if (iskilled){
            System.out.println("Ship is killed by computer");
            iskilled = false;
            isHurted = false;
        }else {
            if (isHurted ){
                System.out.println("Ship is damaged by computer");
                isHurted = false;
            }
            else  {
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

}
