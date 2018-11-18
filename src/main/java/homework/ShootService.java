package homework;

import homework.battle_map.AbstractBattleMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ShootService {

    ArrayList<int []> shootList = new ArrayList<>();


    public int[] shoot(int x, int y) {
        return new int[]{x, y};
    }

    public  boolean isShooted(int[] coordinates, AbstractBattleMap targetBattleMap) {
        return false;
    }

/*    public  boolean checkCoordinatesForCorrect(int[] coordinates) {
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
    }*/

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

/*    public boolean checkCoordinatesForRepeatAndCorrect (int [] coordinatesToCheck){
        return checkCoordinatesForCorrect(coordinatesToCheck) & checkShootForRepeat(coordinatesToCheck);
    }*/










    public ArrayList<int[]> getShootList() {
        return shootList;
    }

    public void setShootList(ArrayList<int[]> shootList) {
        this.shootList = shootList;
    }
}
