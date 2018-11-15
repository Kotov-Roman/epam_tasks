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
        super.setIntermediateCoordinates();
        if (xFrontSideShipPosition != xBacksideShipPosition) {
            xThirdDeckPosition = xBacksideShipPosition - 1;
            xSecondDeckPosition = xBacksideShipPosition - 2;
            yThirdDeckPosition = yBacksideShipPosition;
            ySecondDeckPosition = yBacksideShipPosition;
        }
        else if (xFrontSideShipPosition == xBacksideShipPosition){
            xThirdDeckPosition = xBacksideShipPosition;
            xSecondDeckPosition = xBacksideShipPosition;
            yThirdDeckPosition = yBacksideShipPosition -1;
            ySecondDeckPosition = yBacksideShipPosition -2;
        }
    }
}
