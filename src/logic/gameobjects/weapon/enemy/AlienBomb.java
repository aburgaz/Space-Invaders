package tp1.logic.gameobjects.weapon.enemy;

import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.gameobjects.ship.DestroyerAlien;
import tp1.view.Messages;

public class AlienBomb extends EnemyWeapon {
	private final DestroyerAlien shooter;


	public AlienBomb(DestroyerAlien shooter, GameWorld game) {
		super(game, new Position(shooter.getPos().getCol(), shooter.getPos().getRow()), 1);
		this.shooter = shooter;
		game.addAgain(this);
	}


	// MUERTE
	@Override
	protected void onDelete() {
		shooter.enableBomb();
	}

	// DESCRIPCION
	@Override
	public String getSymbol() {
		return Messages.BOMB_SYMBOL;
	}
}
