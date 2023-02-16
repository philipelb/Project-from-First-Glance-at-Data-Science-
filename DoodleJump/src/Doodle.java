import ledControl.BoardController;
import ledControl.gui.KeyBuffer;
import java.awt.event.KeyEvent;
/**
*@author 	Philip Elberfeld, Tom Kersten, Nicolas Engel
*@version 	01. 11.01.2022
*/

public class Doodle 
{
	private int xPos, yPos;
	private BoardController board;
	private static KeyBuffer key;
	
/**
 * Konstruktor der Klasse Doodle
 * @param controller
 * @param xPos
 * @param yPos
 */
	public Doodle(BoardController controller, int xPos, int yPos) 
	{
		 this.xPos = xPos;
		 this.yPos = yPos;
		 this.board = controller;
		 
	}
	
/**
 * Zeichnet den Doodle
 */
	public void draw ()
	{
		int x = xPos;
		int y = yPos;
		board.setColor(x, y, 127, 127, 0);
	}
	
/**
 * Prueft ob der Doodle au�erhalb des Bildes ist oder nicht
 * Falls er auserhalb ist wird 1 zurueckgegeben 
 * andernfalls wird 100 zurueckgegeben
 * @return
 */
	public int fall ()
	{
		if (getyPos()+1 == 12)
		{
			return 1;
		}
		else 
		{
			return 100;
		}
	}

/*
 * veraendert die Y Koordinate um 1. nach oben
 */
	public void moveUp()
	{
		yPos = yPos -1 ;	
	}

/**
 * veraendert die Y Koordinate um 1. nach unten
 */
	public void moveDown()
	{
		yPos = yPos +1 ;
	}
	
/*
 * veraendert die X Koordinate, je nach dem welche Pfeiltaste gedrueckt wurde, um 1. nach Links oder Rechts
 */
	public void moveToSide ()
	{	
		key = board.getKeyBuffer();	
		KeyEvent button = key.pop();
		if (button != null)
		{
			if (button.getID() == java.awt.event.KeyEvent.KEY_PRESSED)
			{
				if (button.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT)
				{
					if (xPos -1 != 0)
					{
					xPos = xPos -1;
					}
				}
				if (button.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT)
				{
					if (xPos +1 != 12)
					{
					xPos = xPos +1;
					}
				}
			}
		}
	}

	
/**
 * Getter Methode fuer die X Koordinate	
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
 * @return
 */
	public int getyPos() {
		return yPos;
	}

/**
 * Setter Methode fuer die Y Koordinate
 * @param yPos
 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

}
