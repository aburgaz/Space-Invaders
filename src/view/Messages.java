package tp1.view;

import tp1.logic.Level;

/**
 * String literals used in the game.
 * 
 */
public class Messages {

	public static final String VERSION = "3.0";

	public static final String GAME_NAME = "Space Invaders";

	public static final String USAGE = "Usage: %s <level> [<seed>]".formatted(GAME_NAME);

	public static final String USAGE_LEVEL_PARAM = "\t<level>: %s".formatted(Level.all(", "));

	public static final String USAGE_SEED_PARAM = "\t<seed>: %s".formatted(Messages.SEED_NOT_A_NUMBER);

	public static final String WELCOME = String.format("%s %s%n", GAME_NAME, VERSION);

	public static final String ALLOWED_LEVELS = "Level must be one of: %s".formatted(Level.all(", "));

	public static final String SEED_NOT_A_NUMBER = "The seed must be a number";

	public static final String SEED_NOT_A_NUMBER_ERROR = String.format("%s: %%s", SEED_NOT_A_NUMBER);

	public static final String CONFIGURED_LEVEL = "Level: %s";

	public static final String CONFIGURED_SEED = "Random generator initialized with seed: %d";

	public static final String PROMPT = "Command > ";

	public static final String DEBUG = "%n[DEBUG] Executing: %s%n";

	public static final String ERROR = "[ERROR] Error: %s%n";

	public static final String LINE_SEPARATOR = System.lineSeparator();

	/* @formatter:off */
	public static final String[] HELP_LINES = new String[] { "Available commands:",
			"[h]elp : shows this help message",
			"[m]ove <left|lleft|right|rright> : moves the UCMShip to the indicated direction",
			"[n]one | \"\" : user does not perform any action",
			"[s]hoot : player shoots a laser",
			"shock[w]ave : player shoots a shockwave",
			"[l]ist : prints the list of current ships",
			"[e]xit : exits the game",
			"[r]eset [filename] : resets the game using the initial configuration in file filename. If no file is given the standard configuration is used",
			"[s]uper [l]aser : shoots a super laser when player has enough points"};
	/* @formatter:on */

	public static final String HELP = String.join(System.lineSeparator(), HELP_LINES);

	public static final String UNKNOWN_COMMAND = "Unknown command ";

	public static final String COMMAND_PARAMETERS_MISSING = "Missing parameters";

	public static final String COMMAND_INCORRECT_PARAMETER_NUMBER = "Incorrect parameter number";

	public static final String INVALID_POSITION = "Invalid position (%s, %s)";

	public static final String INCORRECT_ENTRY = "Incorrect entry \"%s\". Insufficient parameters.";

	public static final String OFF_WORLD_POSITION = "Position (%s, %s) is off board";

	public static final String INVALID_GAME_OBJECT = String.format("Invalid object%n");

	public static final String INVALID_COMMAND = "Invalid command";

	public static final String UNKNOWN_SHIP = "Unknown ship: \"%s\"";

	public static final String FILE_NOT_FOUND = "File not found: \"%s\"";

	public static final String READ_ERROR = "Undetermined error reading file \"%s\"";

	public static final String ALLOWED_MOVES = "Allowed UCMShip moves: <left|lleft|right|rright>";

	public static final String NOT_ALLOWED_MOVE = "Cannot move in direction %s from position (%s, %s)";

	public static final String NUMBER_OF_CYCLES = "Number of cycles:";

	public static final String REMAINING_ALIENS = "Remaining aliens:";

	public static final String GAME_OVER = "Game over";

	public static final String PLAYER_QUITS = "Player leaves the game";

	public static final String ALIENS_WIN = "Aliens win!";

	public static final String PLAYER_WINS = "Player wins!";

	public static final String AVAILABLE_SHIPS = "Available ships: ";

	public static final String UNEXPECTED_RUNTIME_ERROR = "Oops!";
	
	public static final String SCORE = "Points: ";

	public static final String LIFE = "Life: ";

	public static final String SHOCKWAVE = "ShockWave: ";


	public static final String LASER_ERROR = "Laser cannot be shot";

	public static final String LASER_ALREADY_SHOT = "There is already a laser in the board";

	public static final String SUPERLASER_ERROR = "Super Laser cannot be shot";

	public static final String NO_POINTS = "Not enough points";

	public static final String SHOCKWAVE_ERROR = "ShockWave cannot be shot";
	
	public static final String MOVEMENT_ERROR = "Movement cannot be performed";
	
	public static final String DIRECTION_ERROR = "Wrong direction: ";

	public static final String NOT_ENOUGH_POINTS_ERROR = "Not enough points: only %s points, %s points required";

	public static final String CONFIG_ERROR = "No configuration match: ";
	public static final String DEFAULT_RESET = "Executing default reset";


	//
	// Game Objects
	//
	public static final String GAME_OBJECT_STATUS = "%2s[%02d]";

	public static final String ALIEN_DESCRIPTION = "%s: points='%d', damage='%d', endurance='%d'";

	public static final String UCM_DESCRIPTION = "%s: damage='%d', endurance='%d'";

	public static final String SHOCKWAVE_SYMBOL = "W";

	public static final String BOMB_SYMBOL = "*";

	public static final String LASER_SYMBOL = "oo";

	public static final String SUPERLASER_SYMBOL = "ǁǁ";

	public static final String UCMSHIP_SYMBOL = "^__^";

	public static final String UCMSHIP_DEAD_SYMBOL = "#──#";

	public static final String UCMSHIP_DESCRIPTION = "[U]CM Ship";

	public static final String REGULAR_ALIEN_SYMBOL = "R";

	public static final String REGULAR_ALIEN_DESCRIPTION = "[R]egular Alien";

	public static final String DESTROYER_ALIEN_SYMBOL = "D";

	public static final String DESTROYER_ALIEN_DESCRIPTION = "[D]estroyer Alien";

	public static final String EXPLOSIVE_ALIEN_SYMBOL = "E";

	public static final String EXPLOSIVE_ALIEN_DESCRIPTION = "[E]xplosive Alien";

	public static final String UFO_SYMBOL = "U";

	public static final String UFO_DESCRIPTION = "U[f]o";

	//NEW STRINGS FOR COMMANDS
	public static final String COMMAND_EXIT_NAME = "exit";
	public static final String COMMAND_EXIT_SHORTCUT = "e";
	public static final String COMMAND_EXIT_DETAILS = "Ends the game";
	public static final String COMMAND_EXIT_HELP = "[e]xit";
    public static final String COMMAND_HELP_NAME = "help";
	public static final String COMMAND_HELP_SHORTCUT = "h";
	public static final String COMMAND_HELP_DETAILS = "Prints commands";
	public static final String COMMAND_HELP_HELP = "[h]elp";
	public static final String COMMAND_LIST_NAME = "list";
	public static final String COMMAND_LIST_SHORTCUT = "l";
	public static final String COMMAND_LIST_DETAILS = "Prints the state of the game";
	public static final String COMMAND_LIST_HELP = "[l]ist";
	public static final String COMMAND_NONE_NAME = "none";
	public static final String COMMAND_NONE_SHORTCUT = "n";
	public static final String COMMAND_NONE_DETAILS = "Skips turn";
	public static final String COMMAND_NONE_HELP = "[n]one";
	public static final String COMMAND_RESET_NAME = "reset";
	public static final String COMMAND_RESET_SHORTCUT = "r";
	public static final String COMMAND_RESET_DETAILS = "Starts a new game";
	public static final String COMMAND_RESET_HELP = "[r]eset";
	public static final String COMMAND_SHOCKWAVE_NAME = "shockwave";
	public static final String COMMAND_SHOCKWAVE_SHORTCUT = "w";
	public static final String COMMAND_SHOCKWAVE_DETAILS = "UCM-Ship releases a shock wave";
	public static final String COMMAND_SHOCKWAVE_HELP = "shock[W]ave";
	public static final String COMMAND_SHOOT_NAME = "shoot";
	public static final String COMMAND_SHOOT_SHORTCUT = "s";
	public static final String COMMAND_SHOOT_DETAILS = "UCM-Ship shoots a laser";
	public static final String COMMAND_SHOOT_HELP = "[s]hoot";
	public static final String COMMAND_SUPERLASER_NAME = "superlaser";
	public static final String COMMAND_SUPERLASER_SHORTCUT = "sl";
	public static final String COMMAND_SUPERLASER_DETAILS = "UCM-Ship shoots a superlaser";
	public static final String COMMAND_SUPERLASER_HELP = "[s]uper[l]aser";

	public static final String COMMAND_MOVE_NAME = "move";
	public static final String COMMAND_MOVE_SHORTCUT = "m";
	public static final String COMMAND_MOVE_DETAILS = "Moves UCM-Ship to the indicated direction";
	public static final String COMMAND_MOVE_HELP = "[m]ove <left|lleft|right|rright>";
	public static final String COMMAND_CHEATCODE_NAME = "mamahuevaso";


	/**
	 * Formats an debug message.
	 * 
	 * @param message debug message
	 * 
	 * @return the formated debug message;
	 */
	public static final String debug(String message) {
		return Messages.DEBUG.formatted(message);
	}

	/**
	 * Formats an error message.
	 * 
	 * @param message Error message
	 * 
	 * @return the formated error message;
	 */
	public static final String error(String message) {
		return Messages.ERROR.formatted(message);
	}

	public static final String status(String icon, int lives) {
		return Messages.GAME_OBJECT_STATUS.formatted(icon, lives);
	}

	public static final String alienDescription(String alienNameAndShortcut, int points, int damage, int endurance) {
		return Messages.ALIEN_DESCRIPTION.formatted(alienNameAndShortcut, points, damage, endurance);
	}

	public static final String ucmShipDescription(String ucmShipDescription, int damage, int endurance) {
		return Messages.UCM_DESCRIPTION.formatted(ucmShipDescription, damage, endurance);
	}
}


