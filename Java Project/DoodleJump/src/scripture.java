import ledControl.BoardController;
import ledControl.gui.KeyBuffer;
import java.awt.event.KeyEvent;
/**
*@author 	Philip Elberfeld, Tom Kersten, Nicolas Engel
*@version 	01. 11.01.2022
*/

public class scripture {
	
	private BoardController board;
	private int xPos, yPos;
	private static KeyBuffer key;
	
/**
 * Konstruktor der Klasse scripture
 * @param controller
 * @param xPos
 * @param yPos
 */
	public scripture(BoardController controller,int xPos, int yPos) 
	{
		this.xPos = xPos;
		 this.yPos = yPos;
		 this.board = controller;
		 
		
	}
	
/**
 * Fuert die Methode {@link #buchstabe(String)} aus
 */
	public void draw()
	{
		
		
		buchstabe("play");
		
	}
	
/**
 * Aendert alle Zeichen im �bergebenen String zu Gro�buchstaben und ordnet diese dann in einem Array an.
 * anschlie�end wird mittels eines switch der String gezeichnet 
 * Damit Luecken zwischen den Buchstaben entstehen wird nach jedem Buchstaben die X Koordinate erweitert
 * @param zeichen
 */
	public void buchstabe(String zeichen)
	{
		
		String big = zeichen.toUpperCase();
		int hilfe = xPos;
		int x = xPos;
		int y = yPos;
		
		char[] c = big.toCharArray();
		String[] zeichenA = new String[c.length];

		for(int i = 0; i < c.length; i++) 
		{
		       zeichenA[i] = String.valueOf(c[i]);
		}
		for(int i = 0; i < zeichenA.length; i++)
		{
			x = xPos;
			switch (zeichenA[i])
			{
			case "A":
				board.setColor(x, y+1, 90, 0, 90);
				board.setColor(x, y+2, 90, 0, 90);
				x++;
				board.setColor(x, y, 90, 0, 90);
				board.setColor(x, y+1, 90, 0, 90);
				x++;
				board.setColor(x, y+1, 90, 0, 90);
				board.setColor(x, y+2, 90, 0, 90);
				xPos = x+1;
				break;
			case "L":
				board.setColor(x, y, 90, 0, 90);
				board.setColor(x, y+1, 90, 0, 90);
				board.setColor(x, y+2, 90, 0, 90);
				x++;
				board.setColor(x, y+2, 90, 0, 90);
				xPos = x+2;
				break;
			case "P":
				board.setColor(x, y, 90, 0, 90);
				board.setColor(x, y+1, 90, 0, 90);
				board.setColor(x, y+2, 90, 0, 90);
				x++;
				board.setColor(x, y, 90, 0, 90);
				board.setColor(x, y+1, 90, 0, 90);
				xPos = x+2;
				break;
			case "Y":
				board.setColor(x, y, 90, 0, 90);
				x++;
				board.setColor(x, y+1, 90, 0, 90);
				board.setColor(x, y+2, 90, 0, 90);
				x++;
				board.setColor(x, y, 90, 0, 90);
				xPos = x+2;
				break;
			}
		}
		xPos = hilfe;
	}

/**
 * leert den KeyBuffer und prueft ob Y oder N gedrueckt wurde 
 * Wenn Y gedrueckt wurde wird i auf true gesetzt und zurueckgegeben
 * Wenn X gedrueckt wurde wird i auf false gesetzt und zurueckgegeben
 * @return
 */
	public boolean play() 
	{
		key = board.getKeyBuffer();
		key.clear();
		boolean i = true;
		while (true) 
		{
			KeyEvent button = key.pop();
			if (button != null) 
			{
				if (button.getID() == java.awt.event.KeyEvent.KEY_PRESSED) 
				{
					if (button.getKeyCode() == java.awt.event.KeyEvent.VK_Y) 
					{
						i = true;
						break;
					}

					if (button.getKeyCode() == java.awt.event.KeyEvent.VK_N) 
					{
						i = false;
						break;
					}
				}
			}
		}
		return i;
	}
}




