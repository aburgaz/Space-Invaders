package tp1.logic;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.control.Exceptions.InitializationException;
import tp1.control.InitialConfiguration;

public interface GameModel {

    void updateGame();
    boolean shootLaser();
    boolean shootSuperLaser();
    void move(Move dir) throws CommandExecuteException;
    void showList();
    boolean shockWave();
    void reset();
    void resetConfiguration(InitialConfiguration Configuration) throws InitializationException;
    void exit();
    boolean isFinished();
    void cheatCode();

}
