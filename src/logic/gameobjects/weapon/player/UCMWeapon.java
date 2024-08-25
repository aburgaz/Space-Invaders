package tp1.logic.gameobjects.weapon.player;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.weapon.Weapon;
import tp1.logic.gameobjects.weapon.enemy.EnemyWeapon;

public abstract class UCMWeapon extends Weapon {
    public UCMWeapon(GameWorld game, Position pos, int life, int damage) {
        super(game, pos, life, damage, Move.UP);
    }


    // ATAQUES
    @Override
    public boolean performAttack(GameItem item) {
        return item.receiveAttack(this);
    }

    @Override
    public boolean receiveAttack(EnemyWeapon w) {
        if (pos.equals(w.getPos()) && w.isAlive() && isAlive()) {
            w.receiveAttack();
            receiveDamage(w.getDamage());
            return true;
        }
        return false;
    }

    @Override
    public boolean receiveAttack(UCMWeapon w) {
        return false;
    }
}
