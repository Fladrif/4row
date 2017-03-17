public class Main {
	public static void main(String[] args) {
    Board board = new Board();
    Adversarial advSearch = new Adversarial();

    advSearch.evaluate(board, 1);
	}
  public static void firstTest() {
		Board board = new Board();
		board.getTotalValue();
    if (!board.play("D4", 1)) System.out.println("Played already");
		board.getTotalValue();
    if (!board.play("D5", -1)) System.out.println("Played already");
		board.getTotalValue();

    board.rewindAll(0);
    System.out.println("--- test F4 ---");
    if (!board.test("F4", 1, 1)) System.out.println("Played already");
    board.getTotalValue();
    board.getTotalTestValue(1);

    board.rewindAll(0);
    System.out.println("--- test D6 ---");
    if (!board.test("D6", 1, 1)) System.out.println("Played already");
    board.getTotalValue();
    board.getTotalTestValue(1);

    board.rewindAll(0);
    System.out.println("--- test E5 ---");
    if (!board.test("E5", 1, 1)) System.out.println("Played already");
    board.getTotalValue();
    board.getTotalTestValue(1);

    board.rewindAll(0);
    System.out.println("--- test C5 ---");
    if (!board.test("C5", 1, 1)) System.out.println("Played already");
    board.getTotalValue();
    board.getTotalTestValue(1);
  }
}
