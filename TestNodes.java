public class TestNodes {
  boolean played;
  int player;
  int depth;

  public TestNodes(boolean played, int player, int depth) {
    this.played = played;
    this.player = player;
    this.depth = depth;
  }

  public boolean getPlayed() {
    return played;
  }

  public int getPlayer() {
    return player;
  }

  public int getDepth() {
    return depth;
  }
}
