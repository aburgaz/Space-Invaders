package tp1.logic.lists;

import tp1.logic.Move;
import tp1.logic.Position;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.weapon.enemy.EnemyWeapon;
import tp1.logic.gameobjects.weapon.player.ShockWave;
import tp1.logic.gameobjects.weapon.player.UCMWeapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameObjectContainer {

    private final List<GameObject> objects;

    public GameObjectContainer() {
        objects = new ArrayList<>();
    }


    // GETTERS
    public GameObject getObjectInPosition(int i){
        return objects.get(i);
    }

    public GameObject getObjectInPosition(Position pos){
        for (GameObject object : objects) {
            if (object.isOnPosition(pos)) {
                return object;
            }
        }
        return null;
    }

    public String positionToString(Position pos){   //Devuelve el simbolo para GamePrinter
        for (GameObject object : objects) {

            if (object.isOnPosition(pos)) {
                return object.getDescription();
            }
        }
        return " ";
    }


    //GESTION DE LA LISTA
    public void add(GameObject object) {
        objects.add(object);
    }

    public void removeDead(){
        int i = 0;

        while(i < objects.size()){
            GameObject object = objects.get(i);
            if (!object.isAlive()) {
                object.die();
                removeObject(object);
            }
            i++;
        }
    }

    public void removeDeadPatras(){
        int i = objects.size() - 1;

        while(i >= 0){
            GameObject object = objects.get(i);
            if (!object.isAlive()) {
                object.die();
                removeObject(object);
            }
            i--;
        }
    }

    private void removeObject(GameObject object) {
        objects.remove(object);
    }


    // MOVIMINETO DE OBJETOS
    public void automaticMoves() {

        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            object.automaticMove();
            checkAttacks(i);            // comprueba si está siendo atacado despues de moverse
        }
    }


    // ATAQUES ENTRE OBJETOS
    private void checkAttacks(int i) {
        for (GameObject object : objects) {
            if(objects.get(i).targetable() && !objects.get(i).performAttack(object)){   // Forma intrincada de resolver el caso limite de choque en descenso
                object.performAttack(objects.get(i));                                   // Si el movimiento es en horizontal, se comprueba como de costumbre
            }
        }
    }

    public void receiveShockWave(ShockWave w){
        for (GameObject object : objects) {
            object.receiveAttack(w);
        }
    }
}
