package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyReader {
    public static void main(String[] args) {
        startBattle();
    }

    public static void startBattle() {
        boolean isGameinProcess = true;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            {int result = 0;
                while (isGameinProcess) {
                    switch (result) {
                        case 0: {
                            // result = playerTurn((BufferedReader reader, ArrayList <AbstractShip> listOfEnemyShips); вернет 0 \ 1 \ -1
                            //break;
                            System.out.println("player is playing");
                            String coordinates = reader.readLine();
                            if (coordinates.equals("change")) {
                                result = 1;
                                break;
                            }
                            else if (coordinates.equals("end")) {

                                result = -1;
                                break;
                            }
                            else {
                                result = 0;
                                break;
                            }
                        }
                        case 1: {
                            // result = playerTurn((BufferedReader reader, ArrayList <AbstractShip> listOfEnemyShips); вернет 0 \ 1 \ -1
                            //break;
                            System.out.println("computer is playing");
                            Thread.sleep(1000);
                            result = 0;
                            break;
                        }
                        case -1: {
                            isGameinProcess = false;
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" end !");
    }

    public static String returntString(BufferedReader reader) {
        String a = "";
        try {
            a = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

}






