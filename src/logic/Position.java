package tp1.logic;

public class Position {
	private int col;
	private int row;

	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}

	public Position(Position pos) {
		this.col = pos.col;
		this.row = pos.row;
	}


	// Comparador de posiciones
	public boolean equals(Position pos) {
		return this.getCol() == pos.getCol() && this.getRow() == pos.getRow();
	}


	// Getters
	public int getCol() {
		return this.col;
	}

	public int getRow() {
		return this.row;
	}


	// COMPROBACIONES DEL TABLERO
	public boolean isOut(){
		return col < 0 || col >= Game.DIM_X || row < 0 || row >= Game.DIM_Y;
	}

	public boolean finalRow(){
		return row == Game.DIM_Y - 1;
	}


	// Funcion de movimiento
	public void move(Move dir) {
		switch (dir) {
			case DOWN:
				row += 1;
				break;
			case LEFT:
				col -= 1;
				break;
			case LLEFT:
				col -= 2;
				break;
			case NONE:
				break;
			case RIGHT:
				col += 1;
				break;
			case RRIGHT:
				col += 2;
				break;
			case UP:
				row -= 1;
				break;
			default:
				break;
		}
	}
}
