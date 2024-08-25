package tp1.logic.gameobjects.weapon.player;

import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMSuperLaser extends UCMLaser{
    public UCMSuperLaser(GameWorld game, Position pos, int life) {
        super(game, pos, life, 2);
    }


    // DESCRIPCION
    @Override
    public String getSymbol() {
        return Messages.SUPERLASER_SYMBOL;
    }
}
