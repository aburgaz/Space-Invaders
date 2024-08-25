package tp1.logic;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Objects;
import java.util.Random;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.control.Exceptions.InitializationException;
import tp1.control.InitialConfiguration;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.ship.UCMShip;
import tp1.logic.gameobjects.ship.Ufo;
import tp1.logic.gameobjects.weapon.player.ShockWave;
import tp1.logic.gameobjects.weapon.player.UCMLaser;
import tp1.logic.gameobjects.weapon.player.UCMSuperLaser;
import tp1.logic.lists.GameObjectContainer;
import tp1.view.Messages;

public class Game implements GameModel, GameStatus, GameWorld{

	public static final int DIM_X = 9;
	public static final int DIM_Y = 8;
	public static final int SUPERLASER_POINTS = 5;

	private final Level level;
	private final long seed;
	private int score;
	private UCMShip player;
	private ShockWave shockWave;
	private int cycles;
	private Random rand;
	private AlienManager alienManager;
	private boolean ufoEnabled;
	private boolean leave = false;
	private GameObjectContainer list;

	// Constructor
	public Game(Level level, long seed) {
		this.level = level;
		this.score = 0;
		this.seed = seed;
		this.rand = new Random(seed);
		this.player = new UCMShip(this);
		this.shockWave = new ShockWave(this);
		this.alienManager = new AlienManager(this, this.level);
		this.list = new GameObjectContainer();
		this.ufoEnabled = false;

		addObject();
	}

	// Conversor estado de partida a texto
	public String stateToString() {
		String str = Messages.LIFE + player.getLife() + System.lineSeparator() +
				Messages.SCORE + this.score + System.lineSeparator() +
				Messages.SHOCKWAVE + shockWave.getReady();

		return str;
	}
	// Imprime los elemento de la lista en sus respectivas posiciones
	public String positionToString(int col, int row) {
		Position pos = new Position(col, row);
		return list.positionToString(pos);
	}


	// GETTERS
	public Random getRandom() {
		return rand;
	}

	public int getCycle() {
		return this.cycles;
	}

	public int getRemainingAliens() {
		return alienManager.getRemainingAliens();
	}

	public int getNumCyclesToMoveOneCell() {
		return level.getCyclesToMoveOneCell();
	}

	public Level getLevel() {
		return this.level;
	}

	public int getLife() {
		return this.player.getLife();
	}

	// Añadir score del jugador
	public void addPoints(int points) {
		this.score += points;
	}


	// INSERCION DE OBJETOS
	// Añadir escuadron de naves
	public void addObject() {
		alienManager.initializeContainer(list);
		list.add(player);
	}

	public void addAgain(GameObject object){ 	// Agrega naves, bombas y lasers durante la partida
		list.add(object);
	}

	// GESTION UFO
	private boolean canGenerateRandomUfo() {
		return getRandom().nextDouble() < getLevel().getUfoFrequency();
	}

	public void computerAction() {
		if(!ufoEnabled && canGenerateRandomUfo()){
			ufoEnabled = true;
			addAgain(new Ufo(this,alienManager));
		}
	}

	public void ufoDead(){
		ufoEnabled = false;
	}



	@Override
	public String infoToString() {
		return null;
	}

	// COMPROBACIONES
	public boolean playerWin() {
		return (alienManager.allAlienDead());
	}

	public boolean aliensWin() {
		return !player.isAlive() || haveLanded();
	}

	public boolean isFinished() {
		return playerWin() || aliensWin() || leave;
	}

	private boolean haveLanded() {
		return alienManager.haveLanded(list);
	}


	// LASER Y SHOCKWAVE
	public boolean shootLaser() {
		if (player.shootLaser()) {
			list.add(new UCMLaser(this, player.getPos(), 1, 1));
			return true;
		} else {
			return false;
		}
	}

	public boolean shootSuperLaser(){
		if (score >= SUPERLASER_POINTS){
			if (player.shootLaser()) {
				score -= SUPERLASER_POINTS;
				list.add(new UCMSuperLaser(this, player.getPos(), 1));
				return true;
			} else {
				System.out.println(Messages.LASER_ALREADY_SHOT);
				return false;
			}
		}
		else{
			System.out.println(String.format(Messages.NOT_ENOUGH_POINTS_ERROR, score, SUPERLASER_POINTS));
			return false;
		}
	}

	public void enableLaser(){
		player.enableLaser();
	}

	public boolean shockWave() {	// Disparo de shockwave
		if (shockWave.trigger()) {
			list.receiveShockWave(shockWave);
			return true;
		} else {
			return false;
		}
	}

	public void enableShockWave() {
		shockWave.enableShockWave();
	}


	// NAVE EXPLOSIVA
	public void explosion(Position p){

		for (int i = p.getCol() - 1; i <= p.getCol() + 1; i++) {
			for (int j = p.getRow() - 1; j <= p.getRow() + 1; j++) {
				Position adyacent = new Position(i,j);
				if (list.getObjectInPosition(adyacent) != null) {
					list.getObjectInPosition(adyacent).receiveAttack();
				}
			}
		}
	}


	// MOVIMIENTO
	private void automaticMoves() {
		list.automaticMoves();
		if(player.isAlive()){
			list.removeDeadPatras();
			list.removeDead(); 			//Es necesario revisar dos veces para que se eliminen correctamente
		}
	}

	public void move(Move dir) throws CommandExecuteException {
		player.move(dir);
	}


	// ACCIONES AUTOMATICAS
	private void updateCycles() {
		this.cycles++;
	}

	public void updateGame() {
		updateCycles();
		automaticMoves();
		computerAction();
	}


	//COMANDOS BASICOS
	public void showList() {

		System.out.println(Messages.alienDescription(Messages.REGULAR_ALIEN_DESCRIPTION,5,0,2));
		System.out.println(Messages.alienDescription(Messages.DESTROYER_ALIEN_DESCRIPTION,10,1,1));
		System.out.println(Messages.alienDescription(Messages.EXPLOSIVE_ALIEN_DESCRIPTION,12,1,2));
		System.out.println(player.getInfo());
		System.out.println(Messages.alienDescription(Messages.UFO_DESCRIPTION,25,0,1));
		System.out.println();
	}

	public void cheatCode(){
		shockWave.enableShockWave();
	}

	public void exit() {
		leave = true;
	}


	// RESET
	public void reset() {
		this.score = 0;
		this.rand = new Random(seed);
		this.player = new UCMShip(this);
		this.shockWave = new ShockWave(this);
		this.alienManager = new AlienManager(this, this.level);
		this.list = new GameObjectContainer();
		this.cycles = 0;
		this.ufoEnabled = false;

		addObject();
	}

	public void resetConfiguration(InitialConfiguration conf) throws InitializationException {	// Reset Personalizado
		this.score = 0;
		this.rand = new Random(seed);
		this.player = new UCMShip(this);
		this.shockWave = new ShockWave(this);
		this.alienManager = new AlienManager(this, this.level);
		this.list = new GameObjectContainer();
		this.cycles = 0;
		this.ufoEnabled = false;

		alienManager.costumedInitialization(list, conf); 		// Si falla lanza la excepcion
		list.add(player);
	}
}
