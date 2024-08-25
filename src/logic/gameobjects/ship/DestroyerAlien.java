package tp1.logic.gameobjects.ship;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.logic.gameobjects.weapon.enemy.AlienBomb;
import tp1.logic.gameobjects.weapon.player.UCMLaser;
import tp1.logic.lists.GameObjectContainer;
import tp1.view.Messages;

public class DestroyerAlien extends AlienShip {
    private AlienBomb bomb;
    private boolean canShoot;

    public DestroyerAlien(GameWorld game, Position pos, AlienManager am) {
        super(game, pos, 1, Move.LEFT, 10, am);
        this.canShoot = true;
    }

    public DestroyerAlien() {               //Constructor vacio para la factoria de naves
    }


    // MOVIMIENTO
    @Override
    public void automaticMove() {           // El movimiento depende del resto de las naves, para eso implementamos contadores
        checkAttack = true;         // ESTE BOOLEANO SIRVE PARA SABER SI TIENE QUE COMPROBAR LOS ATAQUES JUSTO DESPUES DE MOVERSE

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
            shootBomb();
        }
    }


    // BOMBA
    public void enableBomb() {
        canShoot = true;
    }

    public void shootBomb() {
        if (canShoot && shootFreq()) {
            this.bomb = new AlienBomb(this, game);
            this.canShoot = false;
        }
    }

    // Funcion probabilidad de disparo
    private boolean shootFreq() {
        return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();
    }


    // DESCRIPTION
    @Override
    public String getSymbol() {
        return Messages.DESTROYER_ALIEN_SYMBOL;
    }

    @Override
    public String getDescription() {
        return String.format(Messages.GAME_OBJECT_STATUS, getSymbol(), this.life);
    }


    // FACTORY
    @Override
    protected AlienShip copy(GameWorld game, Position pos, AlienManager am) {
        return new DestroyerAlien(game, pos, am);
    }
}
