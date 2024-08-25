package tp1.logic.gameobjects.ship;

import tp1.logic.*;
import tp1.logic.gameobjects.weapon.player.ShockWave;

public abstract class AlienShip extends EnemyShip {
    protected int cyclesToMove;

    public AlienShip(GameWorld game, Position pos, int life, Move dir, int points, AlienManager am) {
        super(game, pos, life, dir, points, am);
        this.cyclesToMove = game.getNumCyclesToMoveOneCell();
    }

    public AlienShip() {
    }


    // MOVIMIENTO
    @Override
    public void automaticMove() {
        checkAttack = true;

        if (am.anyOnBorder() && !am.performingMovement()) {        // si alguna esta en el borde y ya se han movido todas, desciende
            performDescend();
            am.descended();            // cuenta cuantas naves han descendido
        } else if (cyclesToMove == 0) {
            performMovement(dir);        // la nave se mueve y cuenta cuantas se han movido ya
            am.moving();
            if (onBorder()) {                // informa si llega al borde
                am.isInBorder();
            }
            this.cyclesToMove = game.getNumCyclesToMoveOneCell();
            checkAttack = false;
        } else {
            cyclesToMove--;
        }
    }

    public void performDescend() {
        performMovement(Move.DOWN);
        changeDirection();
    }

    protected void changeDirection() {
        if (dir == Move.LEFT) {
            dir = Move.RIGHT;
        } else if (dir == Move.RIGHT) {
            this.dir = Move.LEFT;
        }
    }

    public boolean onBorder() {
        return pos.getCol() == 0 && dir == Move.LEFT || pos.getCol() == Game.DIM_X - 1 && dir == Move.RIGHT;
    }


    // ATAQUES
    @Override
    public boolean receiveAttack(ShockWave w) {
        receiveDamage(w.getDamage());
        return true;
    }

    // MUERTE
    @Override
    protected void onDelete() {
        am.updateRemainingAliens();
        super.onDelete();
    }


    // FACTORY
    protected abstract AlienShip copy(GameWorld game, Position pos, AlienManager am);
}
