package tp1.logic;


import tp1.control.Exceptions.CommandParseException;
import tp1.view.Messages;

public enum Move {
	LEFT(-1,0), LLEFT(-2,0), RIGHT(1,0), RRIGHT(2,0), DOWN(0,1), UP(0,-1), NONE(0,0);
	
	private final int x;
	private final int y;

	Move(int x, int y) {
		this.x=x;
		this.y=y;
	}


	//Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	//Conversor de string a enumerado
	public static Move StringToEnum(String option) throws IllegalArgumentException {
        return Move.valueOf(option.toUpperCase());
	}
}
