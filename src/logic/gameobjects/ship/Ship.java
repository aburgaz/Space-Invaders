package tp1.logic.gameobjects.ship;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.weapon.player.ShockWave;

public abstract class Ship extends GameObject {
    protected Move dir;

    public Ship(GameWorld game, Position pos, int life, Move dir) {
        super(game, pos, life, 1);
        this.dir = dir;
    }

    public Ship() {
    }


    // ATAQUES
    public boolean receiveAttack(ShockWave w) {     // solo las alienShip pueden recibir la shockWave
        return false;
    }

    @Override
    public void receiveAttack() {
        receiveDamage(1);
    }

    @Override
    public boolean performAttack(GameItem item) {
        return false;
    }
}
