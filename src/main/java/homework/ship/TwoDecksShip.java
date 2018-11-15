package homework.ship;

public class TwoDecksShip extends AbstractShip {
    public TwoDecksShip(){
        shipView.add('■');
        shipView.add('■');
        lenght = shipView.size();
        isAlive = true;
    }
}
