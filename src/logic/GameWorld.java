package tp1.logic;

import tp1.logic.gameobjects.GameObject;

import java.util.Random;

public interface GameWorld {

    int getNumCyclesToMoveOneCell();
    Level getLevel();
    Random getRandom();
    int getLife();
    void addPoints(int points);
    void addObject();
    void addAgain(GameObject object);
    void computerAction();
    void ufoDead();
    void enableLaser();
    void enableShockWave();
    void explosion(Position pos);
}
