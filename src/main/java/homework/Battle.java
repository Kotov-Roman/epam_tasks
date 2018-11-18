package homework;

import homework.ship.ShipFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle {
    Computer computer = new Computer();
    Player player = new Player();

    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.startBattle();
    }

    public void startBattle() {
        boolean isGameInProcess = true;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            {
                int result = 0;
                //инуструкции как играть
                while (isGameInProcess) {
                    switch (result) {
                        case 0: {// player
                            System.out.println("Player's turn to shoot");
                           /* System.out.println("Enenmy map");
                            computer.computerRealMap.display();
                            System.out.println("player map to draw");
                            player.playerMapToDrowShoots.display();*/
                            //проверка не убиты ли все корабли врага
                            if (computer.computerListOfShips.isEmpty()) {
                                result = -1;
                                System.out.println("Congratulations!!! You are the winner !");
                                System.out.println("Count of shoots: " + player.playerShootList.size());
                                break;
                            }
                            //String coordinates = reader.readLine();
                            //result = player.playerMainTurn(coordinates, computer.getComputerListOfShips());
                            result = 1;
                            break;
                        }
                        case 1: {
                            if (player.getPlayerListOfShips().isEmpty()) {
                                result = -1;
                                System.out.println("You lost! =( ");
                                System.out.println("Count of shoots: " + player.playerShootList.size());
                                // вывести карту кораблей недобитых и выстрелов
                                break;
                            }


                            System.out.println("Computer's turn to shoot");
                            Thread.sleep(1);
                            result = computer.computerTurn(player.getPlayerListOfShips());// result = ComputerTurn(( ArrayList <AbstractShip> listOfEnemyShips), ; вернет 0 \ 1 \ -1
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
        // методы на доп инфу
        System.out.println("End of the game!");
    }


}
