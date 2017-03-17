public class Main {
	public static void main(String[] args) {
    Board board = new Board();
    Adversarial advSearch = new Adversarial();

    System.out.println(advSearch.evaluate(board, 1));
	}

  public static void firstTest() {
		Board board = new Board();
		board.getTotalValue();
    if (!board.play("D4", 1)) System.out.println("Played already");
		System.out.println(board.getTotalValue());

    System.out.println("--- test D5 ---");
    if (!board.test("D5", -1, 1)) System.out.println("Played already");
    System.out.println(board.getTotalTestValue(1));
    System.out.println("--- test E3 ---");
    if (!board.test("E3", 1, 2)) System.out.println("Played already");
    System.out.println(board.getTotalTestValue(2));
    System.out.println("--- test E4 ---");
    if (!board.test("E4", -1, 3)) System.out.println("Played already");
    System.out.println(board.getTotalTestValue(3));
    board.rewindAll(0);

    board.rewindAll(0);
    System.out.println("--- test D6 ---");
    if (!board.test("D6", -1, 1)) System.out.println("Played already");
    board.getTotalValue();
    board.getTotalTestValue(1);

    System.out.println("--- test E3 ---");
    if (!board.test("E3", 1, 1)) System.out.println("Played already");
    System.out.println(board.getTotalTestValue(1));
    board.rewindAll(0);

    if (!board.play("E3", 1)) System.out.println("Played already");
		System.out.println(board.getTotalValue());

    System.out.println("--- test E4 ---");
    if (!board.test("E4", -1, 1)) System.out.println("Played already");
    System.out.println(board.getTotalTestValue(1));
    board.rewindAll(0);
    System.out.println("--- test C5 ---");
    if (!board.test("C5", 1, 1)) System.out.println("Played already");
    board.getTotalValue();
    board.getTotalTestValue(1);
  }
}
