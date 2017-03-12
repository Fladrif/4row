public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		board.getTotalValue();
		try {
			Board newBoard = (Board) board.clone();
			if (!newBoard.play("D4", 1)) System.out.println("Played already");
			board.getTotalValue();
			newBoard.getTotalValue();
		} catch (CloneNotSupportedException err) {
			err.printStackTrace(System.out);
		}
	}
}
