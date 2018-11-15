package homework.ship;

public class ThreeDecksShip extends AbstractShip {
    int xSecondDeckPosition;
    int ySecondDeckPosition;

    public ThreeDecksShip() {
        shipView.add('■');
        shipView.add('■');
        shipView.add('■');
        lenght = shipView.size();
        isAlive = true;
    }

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

    @Override
    public void setCoordinatesList() {
        super.setCoordinatesList();
        shipCoordinatesList.add(new int[]{xSecondDeckPosition, ySecondDeckPosition});
    }
}
