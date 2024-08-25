package tp1.logic.gameobjects.weapon;

import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.weapon.player.ShockWave;

public abstract class Weapon extends GameObject{
    protected Move dir;

    public Weapon(GameWorld game, Position pos, int life, int damage, Move dir) {
        super(game, pos, life, damage);
        this.dir = dir;
    }

    // COMPROBACIONES Y GETTERS
    public int getDamage(){
        return this.damage;
    }

    @Override
    public boolean isAlive() {
        return this.life > 0 && !isOut();
    }


    // MOVIMIENTO
    @Override
    public void automaticMove() {
        performMovement(dir);
    }
    

    // ATAQUES
    public boolean receiveAttack(ShockWave w) {
        return false;
    }

    @Override
    public void receiveAttack() {
        receiveDamage(1);
    }
}
