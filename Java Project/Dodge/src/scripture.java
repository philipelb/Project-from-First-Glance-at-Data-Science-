import ledControl.BoardController;
import ledControl.gui.KeyBuffer;
import java.awt.event.KeyEvent;

 // Philip Elberfeld, Tom Kersken, Sifa Erol

public class scripture {
	
	private BoardController board;
	private int xPos, yPos;
	private static KeyBuffer key;
	

// Konstruktor der Klasse scripture

	public scripture(BoardController controller,int xPos, int yPos) 
	{
		 this.xPos = xPos;
		 this.yPos = yPos;
		 this.board = controller;
		 
		
	}
	

// Fuert die Methoden letter(String, int, int) und number(int) aus

	public void draw(int counter)
	{
		number(counter);
		letter("play",xPos, counter);
		

	}
	

// Aendert alle Zeichen im �bergebenen String zu Gro�buchstaben und ordnet diese dann in einem Array an.
// anschlie�end wird mittels eines switch der String gezeichnet 
// Damit Luecken zwischen den Buchstaben entstehen wird nach jedem Buchstaben die X Koordinate erweitert 
// Falls das Wort l�nger, als das Board ist, wird das Wort �ber den Bildschirm geschoben
// zum zeichnen wird pattern(int, int, int) verwendet
	
	public int letter(String zeichen,int xPos,int counter)
	{
		int counted = 0;
		String big = zeichen.toUpperCase();
		int hilfe = xPos;
		int x = xPos;
		int y = 1;
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
				pattern(9,x,y);
				x++;
				pattern(12,x,y);
				x++;
				pattern(9,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "B":
				pattern(1,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(15,x,y);
				xPos = x+2;
				counted+=4;
				break;
			case "C":
				pattern(10,x,y);
				x++;
				pattern(8,x,y);
				x++;
				pattern(8,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "D":
				pattern(1,x,y);
				x++;
				pattern(8,x,y);
				x++;
				pattern(10,x,y);
				xPos = x+2;
				counted+=4;
				break;
			case "E":
				pattern(1,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(3,x,y);
				xPos = x+2;
				counted+=4;
				break;
			case "F":
				pattern(1,x,y);
				x++;
				pattern(12,x,y);
				x++;
				pattern(12,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "G":
				pattern(9,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(11,x,y);
				xPos = x+2;
				counted+=4;
				break;
			case "H":
				pattern(1,x,y);
				x++;
				pattern(7,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+2;
				counted+=4;
				break;
			case "I":
				x++;
				pattern(1,x,y);
				xPos = x+2;
				counted+=3;
				break;
			case "J":
				pattern(8,x,y);
				x++;
				pattern(8,x,y);
				x++;
				pattern(16,x,y);
				xPos = x+2;
				counted+=4;
				break;
			case "K":
				pattern(1,x,y);
				x++;
				pattern(13,x,y);
				x++;
				pattern(8,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "L":
				pattern(1,x,y);
				x++;
				pattern(17,x,y);
				x++;
				pattern(17,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "M":
				pattern(1,x,y);
				x++;
				pattern(14,x,y);
				x++;
				pattern(7,x,y);
				x++;
				pattern(14,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+1;
				counted+=5;
				break;
			case "N":
				pattern(1,x,y);
				x++;
				pattern(14,x,y);
				x++;
				pattern(7,x,y);
				x++;
				pattern(18,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+1;
				counted+=5;
				break;
			case "O":
				pattern(10,x,y);
				x++;
				pattern(8,x,y);
				x++;
				pattern(10,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "P":
				pattern(1,x,y);
				x++;
				pattern(12,x,y);
				x++;
				pattern(5,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "Q":
				pattern(16,x,y);
				x++;
				pattern(20,x,y);
				x++;
				pattern(16,x,y);
				xPos = x+2;
				counted+=4;
				break;
			case "R":
				pattern(1,x,y);
				x++;
				pattern(11,x,y);
				x++;
				pattern(4,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "S":
				pattern(14,x,y);
				pattern(17,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(6,x,y);
				pattern(18,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "T":
				pattern(6,x,y);
				x++;
				pattern(1,x,y);
				x++;
				pattern(6,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "U":
				pattern(1,x,y);
				x++;
				pattern(17,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+2;
				counted+=4;
				break;
			case "V":
				pattern(16,x,y);
				x++;
				pattern(17,x,y);
				x++;
				pattern(16,x,y);
				xPos = x+2;
				counted+=4;
				break;
			case "W":
				pattern(1,x,y);
				x++;
				pattern(18,x,y);
				x++;
				pattern(7,x,y);
				x++;
				pattern(18,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+2;
				counted+=6;
				break;
			case "X":
				pattern(15,x,y);
				x++;
				pattern(7,x,y);
				x++;
				pattern(15,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "Y":
				pattern(5,x,y);
				x++;
				pattern(19,x,y);
				x++;
				pattern(5,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "Z":
				pattern(20,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(21,x,y);
				xPos = x+1;
				counted+=3;
				break;
			case "_":
				xPos = x+2;
				counted+=2;
				break;
			}
		}
		if(counted>board.getWidth()) {
			while(xPos>0) {
				BoardController controller = BoardController.getBoardController();
				controller.updateBoard();
				board.resetColors();
				board.sleep(300);
			number(counter);	
			letter(zeichen,hilfe-1, counter);
			return xPos;
			}
		}
		xPos = hilfe;
	return xPos;
	}
	

// Die ubergebene Integer Variable wird zunaechst in einen String umgewandelt dieser wird dann in ein charArray zeichen fuer Zeichen eingelesen
// Der Inhalt des charArrays wird dann Zeichen fuer Zeichen in einen StringArray eingelesen und dann Position fuer Position mit dem "switch case" abgegelichen 
// welches dann die jeweilige Zahl zeichnet zum zeichnen wird pattern(int, int, int) verwendet

	public void number(int zeichen)
	{
		
		Integer i =zeichen;
		int hilfe = xPos;
		int x=0;
		int y=8;
		
		String j = i.toString();
		char[] c = j.toCharArray();
		
		String[] zeichenA = new String[c.length];

		for(int k = 0; k < c.length; k++) 
		{
		       zeichenA[k] = String.valueOf(c[k]);
		}
		for(int k = 0; k < zeichenA.length; k++)
		{
			x = xPos;
			
			switch (zeichenA[k])
			{
			case "1":
				pattern(1,x,y);
				xPos = x+2;
				break; 
			case "2":
				pattern(2,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(4,x,y);
				xPos = x+2;
				break;
			case "3":
				pattern(3,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+2;
				break;
			case "4":
				pattern(5,x,y);
				x++;
				pattern(7,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+2;
				break;
			case "5":
				pattern(4,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(2,x,y);
				xPos = x+2;
				break;
			case "6":
				pattern(1,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(2,x,y);
				xPos = x+2;
				break;
			case "7":
				pattern(6,x,y);
				x++;
				pattern(6,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+2;
				break;
			case "8":
				pattern(1,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+2;
				break;
			case "9":
				pattern(4,x,y);
				x++;
				pattern(3,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+2;
				break;
			case "0":
				pattern(1,x,y);
				x++;
				pattern(8,x,y);
				x++;
				pattern(1,x,y);
				xPos = x+2;
				break;
			}
		}
		xPos = hilfe;
	}
	

// Aus den hier moeglichen mustern kann jede zahl und jeder Buchstabe von links nach rechts aufgebaut werden signature ist die Variable mit welcher das 
//jeweils richtige Muster ausgewaehlt wird 

	public void pattern(int signature,int x,int y)
	{
		
		switch (signature)
		{
		case 1:
			board.setColor(x, y, 90, 0, 90);		//o o o o o
			board.setColor(x, y+1, 90, 0, 90);
			board.setColor(x, y+2, 90, 0, 90);
			board.setColor(x, y+3, 90, 0, 90);
			board.setColor(x, y+4, 90, 0, 90);
			break;
		case 2:
			board.setColor(x, y, 90, 0, 90);		//o . o o o
			board.setColor(x, y+2, 90, 0, 90);
			board.setColor(x, y+3, 90, 0, 90);
			board.setColor(x, y+4, 90, 0, 90);
			break;
		case 3:
			board.setColor(x, y, 90, 0, 90);		//o . o . o
			board.setColor(x, y+2, 90, 0, 90);
			board.setColor(x, y+4, 90, 0, 90);
			break;
		case 4:
			board.setColor(x, y, 90, 0, 90);		//o o o . o
			board.setColor(x, y+1, 90, 0, 90);
			board.setColor(x, y+2, 90, 0, 90);
			board.setColor(x, y+4, 90, 0, 90);
			break;
		case 5:
			board.setColor(x, y, 90, 0, 90);		//o o o . .
			board.setColor(x, y+1, 90, 0, 90);
			board.setColor(x, y+2, 90, 0, 90);
			break;
		case 6:
			board.setColor(x, y, 90, 0, 90);		//o . . . .
			break;
		case 7:
			board.setColor(x, y+2, 90, 0, 90);		//. . o . .
			break;
		case 8:
			board.setColor(x, y, 90, 0, 90);		//o . . . o
			board.setColor(x, y+4, 90, 0, 90);
			break;
		case 9:	
			board.setColor(x, y+1, 90, 0, 90);		//. o o o o
			board.setColor(x, y+2, 90, 0, 90);
			board.setColor(x, y+3, 90, 0, 90);
			board.setColor(x, y+4, 90, 0, 90);
			break;
		case 10:
			board.setColor(x, y+1, 90, 0, 90);		//. o o o .
			board.setColor(x, y+2, 90, 0, 90);
			board.setColor(x, y+3, 90, 0, 90);
			break;
		case 11:
			board.setColor(x, y, 90, 0, 90);		//o . o o .
			board.setColor(x, y+2, 90, 0, 90);
			board.setColor(x, y+3, 90, 0, 90);
			break;
		case 12:
			board.setColor(x, y, 90, 0, 90);		//o . o . .
			board.setColor(x, y+2, 90, 0, 90);
			break;
		case 13:
			board.setColor(x, y+1, 90, 0, 90);		//. o . o .
			board.setColor(x, y+3, 90, 0, 90);
			break;
		case 14:
			board.setColor(x, y+1, 90, 0, 90);		//. o . . .
			break;
		case 15:
			board.setColor(x, y, 90, 0, 90);		//o o . o o
			board.setColor(x, y+1, 90, 0, 90);
			board.setColor(x, y+3, 90, 0, 90);
			board.setColor(x, y+4, 90, 0, 90);
			break;
		case 16:
			board.setColor(x, y, 90, 0, 90);		//o o o o .
			board.setColor(x, y+1, 90, 0, 90);
			board.setColor(x, y+2, 90, 0, 90);
			board.setColor(x, y+3, 90, 0, 90);
			break;
		case 17:
			board.setColor(x, y+4, 90, 0, 90);		//. . . . o
			break;
		case 18:
			board.setColor(x, y+3, 90, 0, 90);		//. . . o .
			break;
		case 19:
			board.setColor(x, y+2, 90, 0, 90);		//. . o o o
			board.setColor(x, y+3, 90, 0, 90);
			board.setColor(x, y+4, 90, 0, 90);
			break;
		case 20:
			board.setColor(x, y, 90, 0, 90);		//o . . o o
			board.setColor(x, y+3, 90, 0, 90);
			board.setColor(x, y+4, 90, 0, 90);
			break;
		case 21:
			board.setColor(x, y, 90, 0, 90);		//o o . . o
			board.setColor(x, y+1, 90, 0, 90);
			board.setColor(x, y+4, 90, 0, 90);
			break;
		}
		
	}


// leert den KeyBuffer und prueft ob Enter oder ESC gedrueckt wurde 
// Wenn Enter gedrueckt wurde wird i auf true gesetzt und zurueckgegeben
// Wenn ESC gedrueckt wurde wird i auf false gesetzt und zurueckgegeben

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
					if (button.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) 
					{
						i = true;
						break;
					}

					if (button.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) 
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




