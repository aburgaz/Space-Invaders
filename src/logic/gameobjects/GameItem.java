package tp1.logic.gameobjects;


import tp1.logic.Position;
import tp1.logic.gameobjects.weapon.enemy.EnemyWeapon;
import tp1.logic.gameobjects.weapon.player.ShockWave;
import tp1.logic.gameobjects.weapon.player.UCMWeapon;

public interface GameItem {

    boolean performAttack(GameItem item);
    boolean receiveAttack(EnemyWeapon w);
    boolean receiveAttack(UCMWeapon w);
    boolean receiveAttack(ShockWave w);
    void receiveAttack();            // METODO PARA HACER 1 PUNTO DE DAÑO, ESPECIALMENTE UTIL PARA VARIAS FUNCIONES (Explosion)
}
