package homework.ship;

public class OneDecksShip extends AbstractShip {

    public OneDecksShip(){
        shipView.add('■');
        lenght = shipView.size();
        isAlive = true;
    }
}
