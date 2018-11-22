package sea_battle.ship;

import java.util.ArrayList;

public abstract class AbstractShip {
    /**
     * Initial coordinate x of ship
     */
    int xFrontSideShipPosition;
    /**
     * Initial coordinate y of ship
     */
    int yFrontSideShipPosition;
    /**
     * Last coordinate x of ship
     */
    int xBacksideShipPosition;
    /**
     * Last coordinate y of ship
     */
    int yBacksideShipPosition;

    int length;
    boolean isAlive;

    public int shipLife;

    /**
     * List with coordinates of each deck
     */
    ArrayList<int[]> shipCoordinatesList = new ArrayList<>();

    public ArrayList<int[]> getShipCoordinatesList() {
        return shipCoordinatesList;
    }

    public void setCoordinatesList() {
        shipCoordinatesList.add(new int[]{xFrontSideShipPosition, yFrontSideShipPosition});
        shipCoordinatesList.add(new int[]{xBacksideShipPosition, yBacksideShipPosition});
    }

    public ArrayList<int[]> getAllCoordinatesList() {
        return shipCoordinatesList;
    }

    public void setIntermediateCoordinates() {
    }

    public void setxFrontSideShipPosition(int xFrontSideShipPosition) {
        this.xFrontSideShipPosition = xFrontSideShipPosition;
    }

    public void setyFrontSideShipPosition(int yFrontSideShipPosition) {
        this.yFrontSideShipPosition = yFrontSideShipPosition;
    }

    public void setxBacksideShipPosition(int xBacksideShipPosition) {
        this.xBacksideShipPosition = xBacksideShipPosition;
    }

    public void setyBacksideShipPosition(int yBacksideShipPosition) {
        this.yBacksideShipPosition = yBacksideShipPosition;
    }

    public int getLength() {
        return length;
    }
}
