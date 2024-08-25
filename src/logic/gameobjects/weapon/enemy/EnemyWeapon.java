package tp1.logic.gameobjects.weapon.enemy;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.weapon.Weapon;
import tp1.logic.gameobjects.weapon.player.ShockWave;
import tp1.logic.gameobjects.weapon.player.UCMWeapon;

public abstract class EnemyWeapon extends Weapon {
    public EnemyWeapon(GameWorld game, Position pos, int life) {
        super(game, pos, life, 1,Move.DOWN);
    }


    // ATAQUES
    @Override
    public boolean performAttack(GameItem item) {
        return item.receiveAttack(this);
    }

    @Override
    public boolean receiveAttack(UCMWeapon w) {
        if (pos.equals(w.getPos()) && w.isAlive() && isAlive()) {
            w.receiveAttack();
            receiveDamage(w.getDamage());
            return true;
        }

        return false;
    }

    @Override
    public boolean receiveAttack(EnemyWeapon w) {
        return false;
    }

    @Override
    public boolean receiveAttack(ShockWave w) {
        receiveDamage(w.getDamage());
        return true;
    }
}
