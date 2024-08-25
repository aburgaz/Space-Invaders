package tp1.logic.gameobjects.ship;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExplosiveAlien extends AlienShip {

    public ExplosiveAlien(GameWorld game, Position pos, AlienManager am) {
        super(game, pos, 2, Move.LEFT, 12, am);
    }

    public ExplosiveAlien() {               //Constructor vacio para la factoria de naves
    }


    // MUERTE
    private void explosion() {
        game.explosion(this.pos);
    }

    @Override
    protected void onDelete() {
        super.onDelete();
        explosion();            // esta nave explota al morir
    }


    // DESCRIPCION
    @Override
    public String getSymbol() {
        return Messages.EXPLOSIVE_ALIEN_SYMBOL;
    }

    @Override
    public String getDescription() {
        return String.format(Messages.GAME_OBJECT_STATUS, getSymbol(), this.life);
    }


    //FACTORY
    @Override
    protected AlienShip copy(GameWorld game, Position pos, AlienManager am) {
        return new ExplosiveAlien(game, pos, am);
    }
}
