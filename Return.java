package othello;

public class Return {
	private int p1Count;
	private int p2Count;
	private boolean movePossible;
	public int getP1Count() {
		return p1Count;
	}
	public void setP1Count(int p1Count) {
		this.p1Count = p1Count;
	}
	public int getP2Count() {
		return p2Count;
	}
	public void setP2Count(int p2Count) {
		this.p2Count = p2Count;
	}
	public boolean isMovePossible() {
		return movePossible;
	}
	public void setMovePossible(boolean movePossible) {
		this.movePossible = movePossible;
	}
	public Return(int p1Count, int p2Count, boolean movePossible) {
		super();
		this.p1Count = p1Count;
		this.p2Count = p2Count;
		this.movePossible = movePossible;
	}
	public Return() {
		super();
	}
	
}
