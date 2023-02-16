import ledControl.BoardController;

/**
 * @author Philip Elberfeld, Tom Kersten, Shifa Erol
 * @version 01. 02.01.2023
 */
public class Lines {
	private BoardController board;
	private int xPos, yPos;

	/*
	 * Konstruktor der Klasse
	 */
	public Lines(BoardController board, int xPos, int yPos) {
		this.board = board;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	/*
	 * Zeichnet die Linie
	 */
	public void draw(int k) {
		int x = xPos;
		int y = yPos;
		for (int i = 0; i < 3; i++) {
			board.setColor(x + k, y + i, 127, 127, 127);
		}
	}

}
