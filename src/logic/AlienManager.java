package tp1.logic;

import tp1.control.Exceptions.InitializationException;
import tp1.control.InitialConfiguration;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.ship.AlienShip;
import tp1.logic.gameobjects.ship.DestroyerAlien;
import tp1.logic.gameobjects.ship.RegularAlien;
import tp1.logic.gameobjects.ship.ShipFactory;
import tp1.logic.lists.GameObjectContainer;
import tp1.view.Messages;

public class AlienManager {

    private final Level level;
    private final GameWorld game;
    private final ShipFactory shipFactory;
    private int remainingAliens;
    private final int numRegular;
    private final int numDestroyer;
    private final int offSet;
    private int numDescended;
    private int numMoving;
    private boolean onBorder;

    // Constructor
    public AlienManager(GameWorld game, Level level) {
        this.level = level;
        this.game = game;
        this.shipFactory = new ShipFactory(game, this);
        this.offSet = 1;
        this.numRegular = level.getNumRegularAliens();
        this.numDestroyer = level.getNumDestroyerAliens();
        this.onBorder = false;
        this.numDescended = 0;
        this.numMoving = 0;
    }


    // METODO DE INICIALIZACION

    protected void initializeContainer(GameObjectContainer list) {
        int X = (Game.DIM_X / 2 - level.getNumRegularAliens() / (2 * level.getNumRowsRegularAliens()));
        int Y = (Game.DIM_X / 2 - level.getNumDestroyerAliens() / 2);
        this.remainingAliens = level.getNumRegularAliens() + level.getNumDestroyerAliens();

        if (level == Level.EASY) {
            for (int i = 0; i < level.getNumRowsRegularAliens(); i++) {
                for (int j = 0; j < level.getNumRegularAliens(); j++)
                    list.add(new RegularAlien(game, new Position(X + j, offSet + i), this));
            }
            for (int i = 0; i < level.getNumDestroyerAliens(); i++) {
                list.add(new DestroyerAlien(game, new Position(Y + i, offSet + 1), this));
            }

        } else if (level == Level.HARD) {
            for (int i = 0; i < level.getNumRowsRegularAliens(); i++) {
                for (int j = 0; j < level.getNumRegularAliens() / 2; j++)
                    list.add(new RegularAlien(game, new Position(X + j, offSet + i), this));
            }
            for (int i = 0; i < level.getNumDestroyerAliens(); i++) {
                list.add(new DestroyerAlien(game, new Position(Y + i, offSet + 2), this));
            }
        } else if (level == Level.INSANE) {
            for (int i = 0; i < level.getNumRowsRegularAliens(); i++) {
                for (int j = 0; j < level.getNumRegularAliens() / 2; j++)
                    list.add(new RegularAlien(game, new Position(X + j, offSet + i), this));
            }
            for (int i = 0; i < level.getNumDestroyerAliens(); i++) {
                list.add(new DestroyerAlien(game, new Position(Y + i, offSet + 2), this));
            }
        }
    }

    public void costumedInitialization(GameObjectContainer container, InitialConfiguration conf) throws InitializationException {
        this.remainingAliens = 0;

        for (String shipDescription : conf.getShipDescription()) {
            String[] words = shipDescription.toLowerCase().trim().split("\\s+");
            try {
                Position pos = new Position(Integer.valueOf(words[1]), Integer.valueOf(words[2]));
                if(pos.isOut()){                    //No es una posicion valida
                    throw new InitializationException(String.format(Messages.OFF_WORLD_POSITION,words[1],words[2]));
                }
                AlienShip ship = shipFactory.spawnAlienShip(words[0], pos);
                container.add(ship);
            }
            catch(NumberFormatException e){         //Fallo en la conversion a String
                throw new InitializationException(String.format(Messages.INVALID_POSITION, words[1], words[2]));
            }
            catch (IndexOutOfBoundsException e){    //Falta informacion
                throw new InitializationException(String.format(Messages.INCORRECT_ENTRY, shipDescription));
            }

            this.remainingAliens++;
        }
    }


    // GETTERS Y COMPROBACIONES

    public int getRemainingAliens() {
        return remainingAliens;
    }

    public boolean allAlienDead() {
        return remainingAliens == 0;
    }

    public boolean haveLanded(GameObjectContainer list) {
        for (int i = 0; i < remainingAliens; i++) {         //Comprobamos solo las primeras posciciones (aliens)
            GameObject object = list.getObjectInPosition(i);
            if (object.isInFinalRow()) {
                return true;
            }
        }
        return false;
    }

    public void isInBorder() {
        onBorder = true;
    }

    public boolean anyOnBorder() {
        return onBorder;
    }


    // ACTUALIZACION DE NAVES
    public void updateRemainingAliens() {
        this.remainingAliens--;
    }


    // FUNCIONES PARA UN CORRECTO MOVIMIENTO
    public void descended() {
        numDescended++;
        if (numDescended >= remainingAliens) {            // Cuando han bajado todos se resetea el contador
            numDescended = 0;
            onBorder = false;
        }
    }

    public void moving() {
        numMoving++;
        if (numMoving >= remainingAliens) {
            numMoving = 0;
        }
    }

    public boolean performingMovement() {
        return numMoving != 0;
    }
}
