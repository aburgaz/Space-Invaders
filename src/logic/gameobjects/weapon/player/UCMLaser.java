package tp1.logic.gameobjects.weapon.player;

import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMLaser extends UCMWeapon {
	public UCMLaser(GameWorld game, Position pos, int life, int damage) {
		super(game, new Position(pos.getCol(), pos.getRow()), life, damage);
	}

	//MUELTE
	@Override
	protected void onDelete() {
		game.enableLaser();
	}


	// DESCRIPCION
	@Override
	public String getSymbol() {
		return Messages.LASER_SYMBOL;
	}
}
