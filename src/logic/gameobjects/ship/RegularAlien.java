package tp1.logic.gameobjects.ship;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class RegularAlien extends AlienShip {
    public RegularAlien(GameWorld game, Position pos, AlienManager am) {
        super(game, pos, 2, Move.LEFT, 5, am);
    }

    protected RegularAlien() {               //Constructor vacio para la factoria de naves
    }


    // DECRIPCION
    @Override
    public String getSymbol() {
        return Messages.REGULAR_ALIEN_SYMBOL;
    }

    @Override
    public String getDescription() {
        return String.format(Messages.GAME_OBJECT_STATUS, getSymbol(), this.life);
    }


    // FACTORY
    @Override
    protected AlienShip copy(GameWorld game, Position pos, AlienManager am) {
        return new RegularAlien(game, pos, am);
    }
}