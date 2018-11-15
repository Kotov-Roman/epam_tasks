package homework.ship;

public class ThreeDecksShip extends AbstractShip {
    public ThreeDecksShip (){
        shipView.add('■');
        shipView.add('■');
        shipView.add('■');
        lenght = shipView.size();
        isAlive = true;
    }
}
