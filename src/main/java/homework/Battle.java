package homework;

import homework.battle_map.AbstractBattleMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Battle {
    Computer computer = new Computer();
    Player player = new Player();
    int computerShoots = 0;
    int playerShoots = 0;

    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.startBattle();
    }

    public void startBattle() {
        boolean isGameInProcess = true;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            {
                int result = 0;
                printInstructions(reader);
                while (isGameInProcess) {
                    switch (result) {
                        case 0: {// player

                            if (computer.computerListOfShips.isEmpty()) {
                                result = -1;
                                System.out.println("Congratulations!!! You are the winner !");
                                System.out.println("Count of shoots: " + playerShoots);
                                player.playerMapToDrowShoots.display();
                                break;
                            }
                            //показать обе карты
                            if (playerShoots != 0) {
                                showShootResultOnMap();
                                System.out.println("Player's turn to shoot");
                            }
                            System.out.println("Waiting for input X...");
                            String x = reader.readLine();
                            System.out.println("Waiting for input Y...");
                            String y = reader.readLine();
                            String coordinates = x + "" + y;
                            result = player.playerMainTurn(coordinates, computer.getComputerListOfShips());
                            Thread.sleep(1500);
                            playerShoots++;

                            break;
                        }
                        case 1: {
                            if (player.getPlayerListOfShips().isEmpty()) {
                                result = -1;
                                System.out.println("You lost! =( ");
                                System.out.println("Count of shoots: " + player.playerShootList.size());
                                System.out.println("Map with computer ships:");
                                computer.computerRealMap.display();
                                System.out.println();
                                System.out.println("Your map with shoots:");
                                player.playerMapToDrowShoots.display();
                                break;
                            }
                            clearScreen();
                            System.out.println("Computer's turn to shoot");
                            Thread.sleep(500);
                            result = computer.computerTurn(player.getPlayerListOfShips());
                            computerShoots++;
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

    public void setShootOnMap(ArrayList<int[]> shoots) {
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

    public void showShootResultOnMap() {
        System.out.println("                Your map: ");
        setShootOnMap(computer.computerShootList);
        player.playerRealMap.display();
        System.out.println("                Enemy map:");
        player.playerMapToDrowShoots.display();
    }

    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void printInstructions(BufferedReader reader) {
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
}
