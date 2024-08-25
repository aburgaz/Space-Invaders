package tp1.logic.gameobjects.ship;

import java.util.Arrays;
import java.util.List;

import tp1.control.Exceptions.InitializationException;
import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.Command.Command;
import tp1.view.Messages;

public class ShipFactory {
    private final GameWorld game;
    private final AlienManager am;

    private static final List<AlienShip> AVAILABLE_ALIEN_SHIPS = Arrays.asList(         //ARRAY DE POSIBLES NAVES
            new RegularAlien(),
            new DestroyerAlien(),
            new ExplosiveAlien());

    public ShipFactory(GameWorld game, AlienManager am) {
        this.game = game;
        this.am = am;
    }

    public AlienShip spawnAlienShip(String input, Position pos) throws InitializationException{
        AlienShip ship = null;
        for (AlienShip i : AVAILABLE_ALIEN_SHIPS) {         //Comprueba el input con los simbolos de las naves del array
            if (i.getSymbol().equals(input.toUpperCase())) {
                ship = i.copy(game, pos, am);
            }
            if (ship != null) break;
        }

        if (ship == null){
            throw new InitializationException(String.format(Messages.UNKNOWN_SHIP, input));
        }

        return ship;        //GENERA UNA NAVE SEGUN EL INPUT
    }
}
