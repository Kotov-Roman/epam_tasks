package homework.ship;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShip {
    int xFrontSideShipPosition;
    int yFrontSideShipPosition;
    int xBacksideShipPosition;
    int yBacksideShipPosition;
    int lenght;
    boolean isAlive;
    public ArrayList<int []> shipCoordinatesList = new ArrayList<>();
    List<Character> shipView = new ArrayList<>();

    public ArrayList<String> getShipCoordinatesList(){
        ArrayList <String> list = new ArrayList<>(4);
        list.add("xFrontSideShipPosition = " + xFrontSideShipPosition);
        list.add("yFrontSideShipPosition = " + yFrontSideShipPosition);
        list.add("xBacksideShipPosition = " + xBacksideShipPosition);
        list.add("yBacksideShipPosition = " + yBacksideShipPosition);
        return list;
    }

    public void setCoordinatesList() {
        shipCoordinatesList.add(new int[]{xFrontSideShipPosition, yFrontSideShipPosition});
        shipCoordinatesList.add(new int[]{xBacksideShipPosition, yBacksideShipPosition});
    }

    public ArrayList <int []> getAllCoordinates(){
        return shipCoordinatesList;
    }



    public void setIntermediateCoordinates(){
    }

    public int getxFrontSideShipPosition() {
        return xFrontSideShipPosition;
    }

    public void setxFrontSideShipPosition(int xFrontSideShipPosition) {
        this.xFrontSideShipPosition = xFrontSideShipPosition;
    }

    public int getyFrontSideShipPosition() {
        return yFrontSideShipPosition;
    }

    public void setyFrontSideShipPosition(int yFrontSideShipPosition) {
        this.yFrontSideShipPosition = yFrontSideShipPosition;
    }

    public int getxBacksideShipPosition() {
        return xBacksideShipPosition;
    }

    public void setxBacksideShipPosition(int xBacksideShipPosition) {
        this.xBacksideShipPosition = xBacksideShipPosition;
    }

    public int getyBacksideShipPosition() {
        return yBacksideShipPosition;
    }

    public void setyBacksideShipPosition(int yBacksideShipPosition) {
        this.yBacksideShipPosition = yBacksideShipPosition;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public List<Character> getShipView() {
        return shipView;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public String toString() {
        return shipView.toString();
    }
}
