package tp1.control;

import static tp1.view.Messages.debug;

import java.util.Scanner;

import tp1.control.Exceptions.CommandExecuteException;
import tp1.control.Exceptions.CommandParseException;
import tp1.logic.Command.Command;
import tp1.logic.Command.CommandGenerator;
import tp1.logic.Game;
import tp1.logic.GameModel;
import tp1.view.GamePrinter;
import tp1.view.Messages;

public class Controller {

	private final GameModel game;
	private final Scanner scanner;
	private final GamePrinter printer;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		printer = new GamePrinter(game);
	}

	private String[] prompt() {
		System.out.print(Messages.PROMPT);
		String line = scanner.nextLine();
		String[] words = line.toLowerCase().trim().split("\\s+");

		System.out.println(debug(line));

		return words;
	}

	// Bucle de comandos
	public void run() {

		printGame();
		while (!game.isFinished()) {
			try {
				String[] userWords = prompt();
				Command command = CommandGenerator.parse(userWords);
				if (command != null) {
					if (command.execute(game)) {
						printGame();
					}
				} else {
					System.out.println(Messages.UNKNOWN_COMMAND);
				}
			}
			catch (CommandParseException | CommandExecuteException e) {
				System.out.println(e.getMessage());
				Throwable cause = e.getCause();
				if (cause != null)
					System.out.println(cause.getMessage());
			}
		}
		printEndMessage();
	}

	// Prints
	private void printGame() {
		System.out.println(printer.toString());
	}

	public void printEndMessage() {
		System.out.println(printer.endMessage());
	}

}
