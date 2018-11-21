package homework.ship;

public class ThreeDecksShip extends AbstractShip {
    private int xSecondDeckPosition;
    private int ySecondDeckPosition;

    ThreeDecksShip() {
        isAlive = true;
        shipLife = 3;
        length = 3;
    }

    /**
     * Set coordinates for each deck of ship
     */
    @Override
    public void setIntermediateCoordinates() {
        if (xFrontSideShipPosition != xBacksideShipPosition) {
            xSecondDeckPosition = xBacksideShipPosition - 1;
            ySecondDeckPosition = yBacksideShipPosition;
        } else {
            xSecondDeckPosition = xBacksideShipPosition;
            ySecondDeckPosition = yBacksideShipPosition - 1;
        }
    }
    /**
     * Set coordinates list of each deck of ship
     */
    @Override
    public void setCoordinatesList() {
        super.setCoordinatesList();
        shipCoordinatesList.add(new int[]{xSecondDeckPosition, ySecondDeckPosition});
    }
}
