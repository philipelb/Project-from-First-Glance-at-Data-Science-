import java.awt.event.KeyEvent;
import java.util.Iterator;

import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

/**
 * @author Philip Elberfeld, Tom Kersten, Shifa Erol
 * @version 01. 02.01.2023
 */
public class Character {

	private BoardController board;
	public int xPos, yPos;
	private static KeyBuffer key;

	/*
	 * Konstruktor der Klasse
	 */
	public Character(BoardController controller, int xPos, int yPos) {

		this.xPos = xPos;
		this.yPos = yPos;
		this.board = controller;
	}

	/**
	 * Zeichnet den Character
	 */
	public void draw() {
		int x = xPos;
		int y = yPos;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				board.setColor(x + i, y - j, 0, 127, 0);
			}
		}

	}

	/*
	 * veraendert die X Koordinate, je nach dem welche Pfeiltaste gedrueckt wurde,
	 * um 4 nach Links oder Rechts.
	 */
	public boolean moveToSide() {
		key = board.getKeyBuffer();
		KeyEvent button = key.pop();
		if (button != null) {
			if (button.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
				if (button.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) {
					if (xPos - 1 > 0) {
						if (xPos == 2) {

						} else
							xPos = xPos - 4;
						return true;

					}
				}
				if (button.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) {
					if (xPos + 1 != 20) {
						if (xPos == 17) {

						} else
							xPos = xPos + 4;
						return true;

					}
				}
			}
		}
		return false;
	}

	/**
	 * Getter Methode fuer die X Koordinate
	 * 
	 * @return
	 */
	public int getxPos() {
		return xPos;
	}

	/*
	 * Setter Methode fuer die X Koordinate
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * Getter Methode fuer die Y Koordinate
	 * 
	 * @return
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * Setter Methode fuer die Y Koordinate
	 * 
	 * @param yPos
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
}
