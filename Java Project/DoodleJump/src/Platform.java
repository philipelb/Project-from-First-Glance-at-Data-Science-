import ledControl.BoardController;
/**
*@author 	Philip Elberfeld, Tom Kersten, Nicolas Engel
*@version 	01. 11.01.2022
*/

public class Platform {
	private BoardController board;
	private int xPos, yPos;
	
/**
 * Konstruktor der Klasse 
 * @param controller
 * @param xPos
 * @param yPos
 */
	public Platform(BoardController controller,int xPos, int yPos) 
	{
		 this.xPos = xPos;
		 this.yPos = yPos;
		 this.board = controller;
	}
	
/*
 * Veraendert die Y Position um 1. nach unten  
 */
	public void move()
	{
		yPos = yPos + 1;		
	}
	
/**
 * Zeichnet die Platform indem von der X Koordinate aus 2 neue Punte gezeichnet werden
 */
	public void draw()
	{
		int x = xPos;
		int y = yPos;
		for (int i = 0; i<3;i++)
		{
			board.setColor(x+i, y, 127, 0, 0);
		}
	}

/**
 * Getter Methode fuer die X Koordinate
 * @return
 */
	public int getxPos() {
		return xPos;
	}

/**
 * Setter Methode fuer die X Koordinate
 * @param xPos
 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

/*
 * Getter Methode fuer die Y Koordinate
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
	
	public int Out ()
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

}
