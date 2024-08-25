package tp1.logic.gameobjects.ship;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.logic.gameobjects.weapon.enemy.EnemyWeapon;
import tp1.logic.gameobjects.weapon.player.UCMWeapon;

public abstract class EnemyShip extends Ship {
    private final int points;
    protected final AlienManager am;

    public EnemyShip(GameWorld game, Position pos, int life, Move dir, int points, AlienManager am) {
        super(game, pos, life, dir);
        this.points = points;
        this.am = am;
    }

    public EnemyShip() {
        this.points = 0;
        this.am = null;
    }


    // ATAQUES
    public boolean receiveAttack(EnemyWeapon w) {
        return false;
    }

    @Override
    public boolean receiveAttack(UCMWeapon w) {
        if (pos.equals(w.getPos()) && w.isAlive() && isAlive()) {
            receiveDamage(w.getDamage());
            w.receiveAttack();
            return true;
        }

        return false;
    }


    // MUERTE
    @Override
    protected void onDelete(){
        game.addPoints(points);
    }
}
