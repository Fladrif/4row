import java.util.*;

public class Capsule {
	List<Node> caps = new LinkedList<Node>();
	List<Node> crit = new LinkedList<Node>();
  Queue<TestCapsules> testCaps = new LinkedList<TestCapsules>();
	boolean alive;
	int owner;
	int capsPlayed;
	int critPlayed;
	int value;

	public Capsule(List<Node> caps, List<Node> crit, int numCaps) {
		this.caps = caps; 
		this.crit = crit;
		this.alive = true;
		capsPlayed = numCaps;
		critPlayed = 0;
		owner = 0;
		value = 0;
		for (Node node : caps) {
			node.addCap(this);
		}
		for (Node node : crit) {
			node.addCap(this);
		}
	}

	public void makeMove(String pos, int player) {
		Node cap = caps.stream()
			.filter(node -> node.getPos().equals(pos))
			.findFirst().orElse(null);
		if (cap != null) {
			capsPlayed += cap.getPlayer() != owner ? 1 : 0;
			return;
		}
		if (owner == 0) owner = player;
		Node cri = crit.stream()
			.filter(node -> node.getPos().equals(pos))
			.findFirst().orElse(null);
		if (cri != null) {
			if (cri.getPlayer() == owner) {
				critPlayed += 1;
			} else {
				alive = false;
			}
		}
		if (alive) value = calculateVal(this.capsPlayed, this.critPlayed);
	}

	private int calculateVal(int caps, int crit) {
    int val = 0;
		switch (caps) {
			case 0:
				switch (crit) {
					case 0:
						val = 5 * owner;
						break;
					case 1:
						val = 12 * owner;
						break;
					case 2:
						val = 40 * owner;
						break;
					case 3:
						val = 40 * owner;
				}
				break;
			case 1:
				switch (crit) {
					case 0:
						val = 3 * owner;
						break;
					case 1:
						val = 4 * owner;
						break;
					case 2:
						val = 10 * owner;
						break;
					case 3:
						val = 40 * owner;
				}
				break;
			case 2:
				switch (crit) {
					case 0:
						val = 1 * owner;
						break;
					case 1:
						val = 3 * owner;
						break;
					case 2:
						val = 8 * owner;
						break;
					case 3:
						val = 40 * owner;
				}
		}
    return val;
	}

	public int getValue() {
		return value;
	}

	public boolean isAlive() {
		return alive;
	}
	
	public void print() {
		for (Iterator<Node> capIterator = caps.iterator(); capIterator.hasNext(); ) {
			System.out.print(capIterator.next().getPos() + " ");
		}
		for (Iterator<Node> critIterator = crit.iterator(); critIterator.hasNext(); ) {
			System.out.print(critIterator.next().getPos() + " ");
		}
		System.out.println();
	}

	public void testMove(String pos, int player, int depth) {
    alignTestToDepth(depth - 1);

    if (testCaps.size() == 0) {
      testCaps.add(new TestCapsules(alive, owner, capsPlayed, critPlayed, value, depth));
    } else {
      boolean tempAlive = testCaps.peek().getAlive();
      int tempOwner = testCaps.peek().getOwner();
      int tempCapsPlayed = testCaps.peek().getCapsPlayed();
      int tempCritPlayed = testCaps.peek().getCritPlayed();
      int tempValue = testCaps.peek().getValue();
      testCaps.add(new TestCapsules(tempAlive, tempOwner, tempCapsPlayed, tempCritPlayed, tempValue, depth));
    }

		Node cap = caps.stream()
			.filter(node -> node.getPos().equals(pos))
			.findFirst().orElse(null);
		if (cap != null) {
      if (player != testCaps.peek().getOwner()) {
        testCaps.peek().setCapsPlayed(testCaps.peek().getCapsPlayed() + 1);
      }
			return;
		}
		if (owner == 0) owner = player;
		Node cri = crit.stream()
			.filter(node -> node.getPos().equals(pos))
			.findFirst().orElse(null);
		if (cri != null) {
			if (player == owner) {
        testCaps.peek().setCritPlayed(testCaps.peek().getCritPlayed() + 1);
			} else {
        testCaps.peek().setAlive(false);
			}
		}
		if (testCaps.peek().getAlive()) {
      int val = calculateVal(testCaps.peek().getCapsPlayed(), testCaps.peek().getCritPlayed());
      testCaps.peek().setValue(val);
    }
	}

  public int getTestValue(int depth) {
    alignTestToDepth(depth);
    if (testCaps.size() > 0) {
      int temp = testCaps.peek().getValue();
      if (temp > 0) System.out.println(temp);
      return testCaps.peek().getValue();
    } else {
      return value;
    }
  }

	public boolean isTestAlive(int depth) {
    alignTestToDepth(depth);
    if (testCaps.size() > 0) {
		  return testCaps.peek().getAlive();
    } else {
      return alive;
    }
	}

  public void alignTestToDepth(int depth) {
    while ( testCaps.size() > 0 && testCaps.peek().getDepth() > depth) {
      testCaps.remove();
    }
  }
}
