package tp1.logic.gameobjects.weapon.player;

import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.weapon.enemy.EnemyWeapon;

public class ShockWave extends UCMWeapon{
	
	private boolean ready;
	
	public ShockWave(GameWorld game) {
		super(game, new Position(-1 ,-1), 0, 1);
	}


	// USO DE LA SHOCKWAVE
	public boolean trigger() {
		if (ready) {
			ready = false;
			return true;
		}
		return false;
	}

	public void enableShockWave() {
		ready = true;
	}


	// DESCRIPCION
	public String getReady() {
		return ready ? "ON" : "OFF";
	}


	// METODODS VACIOS
	@Override
	public void automaticMove(){
	}

	@Override
	protected void onDelete(){
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public String getSymbol() {
		return null;
	}

	@Override
	public boolean performAttack(GameItem item) {
		return false;
	}

	@Override
	public boolean receiveAttack(EnemyWeapon w) {
		return false;
	}
}
