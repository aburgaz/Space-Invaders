package tp1.logic.gameobjects.ship;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.control.Exceptions.CommandParseException;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.logic.gameobjects.weapon.enemy.EnemyWeapon;
import tp1.logic.gameobjects.weapon.player.UCMWeapon;
import tp1.view.Messages;

public final class UCMShip extends Ship {
	public static final int INITIAL_COL = Game.DIM_X/2;
	public static final int INITIAL_ROW = Game.DIM_Y -1;

	private boolean canShoot;

	// Constructor
	public UCMShip(GameWorld game) {
		super(game, new Position(INITIAL_COL, INITIAL_ROW), 3, Move.NONE);
		this.canShoot = true;
	}

	// MUERTE
	@Override
	protected void onDelete() {
	}


	// MOVIMIENTO
	@Override
	public void automaticMove() {
	}

	public void move(Move sdir) throws CommandExecuteException {

		Position lastPos = new Position(pos.getCol(), pos.getRow());
		
		pos.move(sdir);

		if (isOut()) {
			pos = lastPos; 				// si la nueva posicion esta fuera del tablero retrocede a la posicion inicial
			throw new CommandExecuteException(Messages.MOVEMENT_ERROR + Messages.LINE_SEPARATOR
												+ String.format(Messages.NOT_ALLOWED_MOVE, sdir,lastPos.getCol(), lastPos.getRow()));
		}
	}


	// LASER
	public void enableLaser() {
		canShoot = true;
	}

	public boolean shootLaser() {
		if (this.canShoot) {
			this.canShoot = false;
			return true;
		}
		return false;
	}


	// ATAQUES
	@Override
	public boolean receiveAttack(EnemyWeapon w) {
		if (pos.equals(w.getPos()) && w.isAlive() && isAlive()) {
			receiveDamage(w.getDamage());
			w.receiveAttack();
			return true;
		}
		return false;
	}

	@Override
	public boolean receiveAttack(UCMWeapon w) {
		return false;
	}


	// DESCRIPCION
	public String getInfo(){
		return String.format(Messages.UCM_DESCRIPTION,Messages.UCMSHIP_DESCRIPTION,damage,life);
	}

	@Override
	public String getSymbol() {
		return isAlive() ? Messages.UCMSHIP_SYMBOL : Messages.UCMSHIP_DEAD_SYMBOL;
	}
}
