package tp1.logic.gameobjects;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.logic.lists.GameObjectContainer;

public abstract class GameObject implements GameItem{
    protected GameWorld game;
    protected Position pos;
    protected int life;
    protected int damage;
    protected boolean checkAttack;      // se usa para arreglar unos casos limite

    public GameObject(GameWorld game, Position pos, int life, int damage) {
        this.game = game;
        this.life = life;
        this.pos = pos;
        this.damage = damage;
        checkAttack = true;
    }

    public GameObject() {               //Constructor vacio para la factoria de naves
    }

    //COMPROBACIONES GENERALES Y GETTERS
    public boolean isOnPosition(Position posX) {
        return this.pos.equals(posX);
    }

    public boolean isInFinalRow() {
        return this.pos.finalRow();
    }

    public boolean isOut() {
        return pos.isOut();
    }

    public boolean isAlive() {
        return this.life > 0;
    }

    public int getLife() {
        return this.life;
    }

    public Position getPos() {
        return this.pos;
    }

    public boolean targetable(){
        return checkAttack;         // muestra si la neve es atacable durante el movimiento (Importante para el descenso)
    }


    //MUERTE DEL OBJECTO
    public void die() {
        onDelete();
    }

    protected abstract void onDelete();


    //MOVIMIENTO
    public abstract void automaticMove();

    protected void performMovement(Move dir){
        this.pos.move(dir);
    }

    protected void receiveDamage(int damage) {
        this.life -= damage;
    }


    //DESCRIPCION
    public abstract String getSymbol();

    public String getDescription(){
        return getSymbol();
    }
}

