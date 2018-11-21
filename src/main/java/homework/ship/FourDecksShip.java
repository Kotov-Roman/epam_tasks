package homework.ship;

public class FourDecksShip extends AbstractShip {
    private int xSecondDeckPosition;
    private int ySecondDeckPosition;
    private int xThirdDeckPosition;
    private int yThirdDeckPosition;

    FourDecksShip() {
        shipLife = 4;
        length =4;
        isAlive = true;
    }

    /**
     * Set coordinates for each deck of ship
     */
    @Override
    public void setIntermediateCoordinates() {
        if (xFrontSideShipPosition != xBacksideShipPosition) {
            xThirdDeckPosition = xBacksideShipPosition - 1;
            xSecondDeckPosition = xBacksideShipPosition - 2;
            yThirdDeckPosition = yBacksideShipPosition;
            ySecondDeckPosition = yBacksideShipPosition;
        } else {
            xThirdDeckPosition = xBacksideShipPosition;
            xSecondDeckPosition = xBacksideShipPosition;
            yThirdDeckPosition = yBacksideShipPosition - 1;
            ySecondDeckPosition = yBacksideShipPosition - 2;
        }
    }

    /**
     * Set coordinates list of ship
     */
    @Override
    public void setCoordinatesList() {
        super.setCoordinatesList();
        shipCoordinatesList.add(new int[]{xSecondDeckPosition, ySecondDeckPosition});
        shipCoordinatesList.add(new int[]{xThirdDeckPosition, yThirdDeckPosition});
    }
}
