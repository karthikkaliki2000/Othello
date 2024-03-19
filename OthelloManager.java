package othello;


import java.util.Scanner;

public class OthelloManager {

	static Scanner s = new Scanner(System.in);

	final static int p1Symbol = 1;
	final static int p2Symbol = 2;

	public static void main(String[] args) {
		System.out.println("Let's Start the game!!");
		System.out.println("Enter Player1 name: ");
		String p1Name=s.next();
		System.out.println("Player1 Symbol is 1");
		//int p1Symbol=s.nextInt();
		
		System.out.println("Enter Player2 name: ");
		String p2Name=s.next();
		System.out.println("Player1 Symbol is 2");
		//int p2Symbol=s.nextInt();
		
		OthelloBoard b = new OthelloBoard();
		int n = 60;
		int m=n;
		boolean p1Turn = true;
		Return r;
		while(n > 0) {
			
			int x;
			int y;
			boolean ans = false;
			if(p1Turn) {
				System.out.println("Enter player1 turn");
				
				System.out.println("Enter x and y: ");
				x = s.nextInt();
				y = s.nextInt();
				r=b.move(p1Symbol, x, y);
				ans = r.isMovePossible();
				
			}
			else {
				System.out.println("Enter player2 turn");
				System.out.println("Enter x and y: ");
				x = s.nextInt();
				y = s.nextInt();
				r = b.move(p2Symbol, x, y);
				ans = r.isMovePossible();
			}
			if(ans) {
				b.print();
				System.out.println("Player1 points are : "+r.getP1Count());
				System.out.println("Player2 points are : "+r.getP2Count());
				if(r.getP1Count()+r.getP2Count()>=m) {
					if(r.getP1Count()>r.getP2Count()) {
						System.out.println("Player 1 win");
						
					}
					else if(r.getP1Count()<r.getP2Count()){
						System.out.println("Player 2 win");
					}
					else {
						System.out.println("Draw!!");
					}
					break;
				}
				p1Turn = !p1Turn;
				n--;
				System.out.println("There are still "+n+" chances remaining");
			}
			else {
				System.out.println(ans);
				System.out.println("Invalid Move! Try again!!");
				
			}
		}
	}
}