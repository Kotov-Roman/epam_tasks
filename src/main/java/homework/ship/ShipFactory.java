package homework.ship;

public class ShipFactory {
    /**
     * @param length - length of ship which should be created
     * @return created ship or @null if size input is wrong
     */
    public AbstractShip createShip(int length) {
        switch (length) {
            case 1:
                return new OneDecksShip();
            case 2:
                return new TwoDecksShip();
            case 3:
                return new ThreeDecksShip();
            case 4:
                return new FourDecksShip();
            default:
                System.out.println("Wrong size. It should be 1 <= size <=4 ");
                return null;
        }
    }
}





