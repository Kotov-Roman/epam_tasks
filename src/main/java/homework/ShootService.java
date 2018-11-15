package homework;

import homework.battle_map.AbstractBattleMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ShootService {

    ArrayList<int []> shootList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ShootService playerShootService = new ShootService();
        int[] shootCoordinates = playerShootService.shoot(10, 9);
        int[] shootCoordinates1 = playerShootService.shoot(9, 9);
        int[] shootCoordinates2 = playerShootService.shoot(0, 0);
        ArrayList<int []> list = new ArrayList<>();
        list.add(shootCoordinates);
        list.add(shootCoordinates);
        list.add(shootCoordinates1);
        list.add(shootCoordinates1);
        list.add(shootCoordinates2);
        list.add(shootCoordinates2);

        for (int[] shoot :list) {
            if (playerShootService.checkCoordinatesForRepeatAndCorrect(shoot)){
                playerShootService.addCoordinatesToShootList(shoot);
            }
        }

        for (int[] shoot :playerShootService.getShootList()){
            System.out.println(Arrays.toString(shoot));
        }
    }

    public int[] shoot(int x, int y) {
        return new int[]{x, y};
    }

    public  boolean isShooted(int[] coordinates, AbstractBattleMap targetBattleMap) {
        return false;
    }

    public  boolean checkCoordinatesForCorrect(int[] coordinates) {
        int x = coordinates[0];
        int y = coordinates[1];
        boolean isX_Correct = (x < 10) & (x >= 0);
        boolean isY_Correct = (y< 10) & (y >= 0);
        if (isX_Correct & isY_Correct){
            return true;
        }else {
            System.out.println("wrong input");
            return false;
        }
    }

    public void addCoordinatesToShootList(int [] coordinatesToAdd ){
        shootList.add(coordinatesToAdd);
    }

    public boolean checkShootForRepeat(int [] coordinatesToCheck){
        for (int[] coordinatesFromList : shootList) {
            if (Arrays.equals(coordinatesFromList, coordinatesToCheck)) {
                System.out.println("you already shoot at this shipCoordinatesList, input different shipCoordinatesList  ");
                return false;
            }
        }
        return true;
    }

    public boolean checkCoordinatesForRepeatAndCorrect (int [] coordinatesToCheck){
        return checkCoordinatesForCorrect(coordinatesToCheck) & checkShootForRepeat(coordinatesToCheck);
    }










    public ArrayList<int[]> getShootList() {
        return shootList;
    }

    public void setShootList(ArrayList<int[]> shootList) {
        this.shootList = shootList;
    }
}
