package othello;


public class OthelloBoard {

	private int board[][];
	private final int player1Symbol=1;
	private final int player2Symbol=2;
	private static int p1Count=2;
	private static int p2Count=2;
	private static int totalCount=0;
	Return r;


	public OthelloBoard() {
		
		super();
		board = new int[8][8];
		
		board[3][3] = player1Symbol;
		board[3][4] = player2Symbol;
		board[4][3] = player2Symbol;
		board[4][4] = player1Symbol;
	}

	public void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	int[] xDir = { -1, -1, 0, 1, 1, 1, 0, -1 };
	int[] yDir = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public Return move(int symbol, int x, int y) {
		r=new Return();
		if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] != 0) {
			r.setMovePossible(false);
			r.setP1Count(p1Count);
			r.setP2Count(p2Count);
			return r;
		}
		boolean movePossible = false;
		for (int i = 0; i < xDir.length; i++) {
			int xStep = xDir[i];
			int yStep = yDir[i];
			int currentX = x + xStep;
			int currentY = y + yStep;
			int count = 0; // count of opponent's pieces encountered
			while (currentX >= 0 && currentX < 8 && currentY >= 0 && currentY < 8) {
//Empty cell
				if (board[currentX][currentY] == 0) {
					break;
				} else if (board[currentX][currentY] != symbol) {
					currentX += xStep;
					currentY += yStep;
					
					count++;
				} else {
//conversion is possible
					if (count > 0) {
						movePossible = true;
						if(symbol==1) {
							p1Count+=count;
							p2Count-=count;
						}
						else if(symbol==2){
							p2Count+=count;
							p1Count-=count;
						}
						
						int convertX = currentX - xStep;
						int convertY = currentY - yStep;
						while (convertX != x || convertY != y) {
							board[convertX][convertY] = symbol;
							convertX = convertX - xStep;
							convertY = convertY - yStep;
						}
					}
					break;
				}
			}
		}
		if (movePossible) {
			if(symbol==1) {
				p1Count++;
			}
			else if(symbol==2){
				p2Count++;
			}
			board[x][y] = symbol;
		}
		r=new Return(p1Count, p2Count, movePossible);
		return r;
	}
}
