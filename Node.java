import java.util.*;

public class Node {
	List<Capsule> capsules = new LinkedList<Capsule>();
  Queue<TestNodes> testNodes = new LinkedList<TestNodes>();
	String pos;
	boolean played;
	int player;

	public Node(String pos) {
		this.pos = pos;
		this.player = 0;
		this.played = false;
	}

	public void addCap(Capsule cap) {
		capsules.add(cap);
	}

	public boolean play(int player) {
		if (played) return false;
		this.player = player;
		this.played = true;
		for (Capsule capsul : capsules) {
			capsul.makeMove(this.pos, player);
		}
		return true;
	}

	public int getPlayer() {
		return player;
	}

	public String getPos() {
		return pos;
	}

	public boolean test(int player, int depth) {
    alignTestToDepth(depth - 1);

    if (testNodes.size() > 0) {
      if (testNodes.peek().getPlayed()) return false;
    } else {
      if (played) return false;
    }
    testNodes.add(new TestNodes(true, player, depth));
		for (Capsule capsul : capsules) {
			capsul.testMove(this.pos, player, depth);
		}
		return true;
	}

  public int getTestPlayer(int depth) {
    alignTestToDepth(depth);
    if (testNodes.size() > 0) {
      return testNodes.peek().getPlayer();
    } else {
      return player;
    }
  }

  public void alignTestToDepth(int depth) {
    while (testNodes.size() > 0 && testNodes.peek().getDepth() > depth) {
      testNodes.remove();
    }
  }
}
