package sea_battle;

import sea_battle.battle_map.AbstractBattleMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Battle {
    private Computer computer = new Computer();
    private Player player = new Player();
    private int playerShoots = 0;

    /**
     * Basic method of game. Each method turn can return 0 or 1 or -1. In case 0 player will shoot.
     * In case 1 computer will shoot. In case 0 game will finish.
     */
    public void startBattle() {
        boolean isGameInProcess = true;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            {
                int result = 0;
                printInstructions(reader);
                while (isGameInProcess) {
                    switch (result) {
                        case 0: {
                            if (computer.computerListOfShips.isEmpty()) {
                                result = -1;
                                printWonCase();
                                break;
                            }
                            if (playerShoots != 0) {
                                showShootResultOnMap();
                                System.out.println("Player's turn to shoot");
                            }
                            String coordinates = getInput(reader);
                            result = player.playerMainTurn(coordinates, computer.getComputerListOfShips());
                            Thread.sleep(1500);
                            playerShoots++;
                            break;
                        }
                        case 1: {
                            if (player.getPlayerListOfShips().isEmpty()) {
                                result = -1;
                                printLostCase();
                                break;
                            }
                            clearScreen();
                            System.out.println("Computer's turn to shoot");
                            Thread.sleep(500);
                            result = computer.computerTurn(player.getPlayerListOfShips());
                            computer.showLastShootCoordinates();
                            Thread.sleep(500);
                            showShootResultOnMap();
                            System.out.println("Press Enter to continue...");
                            reader.readLine();
                            clearScreen();
                            break;
                        }
                        case -1: {
                            isGameInProcess = false;
                            break;
                        }
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of the game!");
    }

    /**
     * Method change map vivsion in case of hit.
     *
     * @param shoots computer shoot list
     */
    private void setShootOnMap(ArrayList<int[]> shoots) {
        AbstractBattleMap battleMap = player.playerRealMap;
        ArrayList<ArrayList<Character>> map = battleMap.getMap();
        for (int[] coordinates : shoots) {
            int x = coordinates[0];
            int y = coordinates[1];
            if (map.get(y).get(x).equals('☐')) {
                map.get(y).set(x, '✕');
            }
            if (map.get(y).get(x).equals('■')) {
                map.get(y).set(x, '☒');
            }
        }
    }

    /**
     * Method display 2 maps with shoot results
     */
    private void showShootResultOnMap() {
        System.out.println("                Your map: ");
        setShootOnMap(computer.computerShootList);
        player.playerRealMap.display();
        System.out.println("                Enemy map:");
        player.playerMapToDrowShoots.display();
    }

    /**
     * Method clears screen for opponent turn
     */
    private void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Method displays instruction at the start of the game
     *
     * @param reader takes input
     */
    private void printInstructions(BufferedReader reader) {
        System.out.println("Hello! It's particular sea battle game.");
        System.out.println("The rules are easy. At first input X coordinate");
        System.out.println("Next input Y coordinate and follow the instructions");
        System.out.println("Press Enter to start battle...");
        try {
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("                Your map: ");
        player.playerRealMap.display();
        System.out.println("                Enemy map");
        player.playerMapToDrowShoots.display();
        System.out.println("Player's turn to shoot");
    }

    /**
     * Displays player's lost case
     */
    private void printLostCase() {
        System.out.println("You lost! =( ");
        System.out.println("Count of shoots: " + player.playerShootList.size());
        System.out.println("Map with computer ships:");
        computer.computerRealMap.display();
        System.out.println();
        System.out.println("Your map with shoots:");
        player.playerMapToDrowShoots.display();
    }

    /**
     * Displays player's won case
     */
    private void printWonCase() {
        System.out.println("Congratulations!!! You are the winner !");
        System.out.println("Count of shoots: " + playerShoots);
        player.playerMapToDrowShoots.display();
    }

    /**
     * @param reader takes input coordinates
     * @return string result of input
     */
    private String getInput(BufferedReader reader) throws IOException {
        System.out.println("Waiting for input X...");
        String x = reader.readLine();
        System.out.println("Waiting for input Y...");
        String y = reader.readLine();
        return x + "" + y;
    }
}
