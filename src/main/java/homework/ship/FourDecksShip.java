package homework.ship;

public class FourDecksShip extends AbstractShip {
    int xSecondDeckPosition;
    int ySecondDeckPosition;
    int xThirdDeckPosition;
    int yThirdDeckPosition;

    public FourDecksShip() {
        shipView.add('■');
        shipView.add('■');
        shipView.add('■');
        shipView.add('■');
        lenght = shipView.size();
        isAlive = true;
    }

    @Override
    public void setIntermediateCoordinates() {
        if (xFrontSideShipPosition != xBacksideShipPosition) {
            xThirdDeckPosition = xBacksideShipPosition - 1;
            xSecondDeckPosition = xBacksideShipPosition - 2;
            yThirdDeckPosition = yBacksideShipPosition;
            ySecondDeckPosition = yBacksideShipPosition;
        }
        else {
            xThirdDeckPosition = xBacksideShipPosition;
            xSecondDeckPosition = xBacksideShipPosition;
            yThirdDeckPosition = yBacksideShipPosition -1;
            ySecondDeckPosition = yBacksideShipPosition -2;
        }
    }

    @Override
    public void setCoordinatesList() {
        super.setCoordinatesList();
        shipCoordinatesList.add(new int[]{xSecondDeckPosition, ySecondDeckPosition});
        shipCoordinatesList.add(new int[]{xThirdDeckPosition, yThirdDeckPosition});
    }
}
