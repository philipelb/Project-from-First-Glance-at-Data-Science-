import java.awt.event.KeyEvent;

import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

/**
 * @author Philip Elberfeld, Tom Kersten, Shifa Erol
 * @version 01. 02.01.2023
 */
public class Auto {
	private BoardController board;
	private int xPos, yPos;

	/*
	 * Konstruktor der Klasse
	 */
	public Auto(BoardController controller, int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.board = controller;
	}

	/*
	 * Veraendert die yPos vom Auto um 1 wenn der übergebene Wert eine gerade Zahl
	 * ist
	 */
	public void move(int i) {
		if (i % 2 == 0) {
			this.yPos += 1;
		}
		i++;

	}

	/**
	 * Zeichnet das Auto
	 */
	public void draw() {
		int x = xPos;
		int y = yPos;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				board.setColor(x + i, y - j, 127, 127, 0);
			}
		}
	}

	/*
	 * checkt ob das Auto außerhalb der Anzeige ist und gibt entsprechend true oder
	 * false zurück
	 * 
	 */
	public boolean Out() {
		if (getyPos() + 1 == 20) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Getter Methode fuer die X Koordinate
	 * 
	 * @return
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * Setter Methode fuer die X Koordinate
	 * 
	 * @param xPos
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
