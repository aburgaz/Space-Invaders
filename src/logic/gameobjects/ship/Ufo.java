package tp1.logic.gameobjects.ship;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.lists.GameObjectContainer;
import tp1.view.Messages;

public class Ufo extends EnemyShip {
	private boolean gone;			// Se utiliza para saber si el ufo ha atravesado el tablero o no

	public Ufo(GameWorld game,AlienManager am) {
		super(game, new Position(Game.DIM_X - 1, 0), 1, Move.LEFT, 25,am);
		gone = false;
	}


	// MOVIMIENTO
	@Override
	public void automaticMove() {
		performMovement(dir);
		beyondBorder();				// Comprueba si se sale del tablero
	}


	// MUERTE
	@Override
	protected void onDelete(){
		if (!gone){ 			// solo entra si el ufo muere por un laser
			super.onDelete();
			game.enableShockWave();
		}
		game.ufoDead();
	}

	public void beyondBorder() {
		if (isOut()) {
			this.life = 0;
			gone = true;
		}
	}


	// DESCRIPCION
	public String getDescription() {
		return String.format(Messages.GAME_OBJECT_STATUS, Messages.UFO_SYMBOL, this.life);
	}

	@Override
	public String getSymbol() {
		return Messages.UFO_SYMBOL;
	}

}
