import java.util.*;

public class Board {
	List<Node> nodes = new LinkedList<Node>();
	List<Capsule> capsules = new LinkedList<Capsule>();
	HashMap<Integer, String> dict = new HashMap<Integer, String>();

	public Board() {
		dict.put(1, "A");
		dict.put(2, "B");
		dict.put(3, "C");
		dict.put(4, "D");
		dict.put(5, "E");
		dict.put(6, "F");
		dict.put(7, "G");
		dict.put(8, "H");
		createNodes();
		createCapsules();
		// for (Iterator<Capsule> capsulIterator = capsules.iterator(); capsulIterator.hasNext(); ) {
		// 	capsulIterator.next().print();
		// }
	}

	public boolean play(String pos, int player) {
		if (nodes.stream().filter(node -> {
				return node.getPos().equals(pos);
			}).findFirst()
				.get()
				.play(player)) {
			return true;
		} else { return false; }
	}

	public int getTotalValue() {
		int total = 0;
		for (Capsule capsul : capsules) {
			if (capsul.isAlive()) total += capsul.getValue();
		}
		return total;
	}

	private void createNodes() {
		for (int i = 1; i < 9; i++) {
			for (int k = 1; k < 9; k++) {
				nodes.add(new Node(dict.get(i) + Integer.toString(k)));
			}
		}
	}

	private void createCapsules() {
		for (int i = 1; i < 9; i++) {
			createHorizontalCapsules(dict.get(i));
			createVerticalCapsules(i);
		}
	}

	private void createHorizontalCapsules(String yPos) {
		int botRange = 1;
		int topRange = 5;
		for (int k = 1; k < 6; k++) {
			List<Node> caps = new LinkedList<Node>();
			List<Node> crit = new LinkedList<Node>();
			if (k == 1) {
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = yPos + "5";
							return node.getPos().equals(pos);
						})
						.findFirst()
						.get()
				);
				for (int tempCap = botRange; tempCap < topRange; tempCap++) {
					final int capIt = tempCap;
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = yPos + Integer.toString(capIt);
								return node.getPos().equals(pos); 
							})
							.findFirst()
							.get()
					);
				}
				topRange++;
			} else if (k == 5) {
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = yPos + "4";
							return node.getPos().equals(pos); 
						})
						.findFirst()
						.get()
				);
				for (int tempCap = botRange + 1; tempCap <= topRange; tempCap++) {
					final int capIt = tempCap;
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = yPos + Integer.toString(capIt);
								return node.getPos().equals(pos); 
							})
							.findFirst()
							.get()
					);
				}
			} else {
				final int botNum = botRange;
				final int topNum = topRange;
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = yPos + Integer.toString(botNum);
							return node.getPos().equals(pos); 
						})
						.findFirst()
						.get()
				);
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = yPos + Integer.toString(topNum);
							return node.getPos().equals(pos); 
						})
						.findFirst()
						.get()
				);
				for (int tempCap = botRange + 1; tempCap < topRange; tempCap++) {
					final int capIt = tempCap;
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = yPos + Integer.toString(capIt);
								return node.getPos().equals(pos); 
							})
							.findFirst()
							.get()
					);
				}
				botRange++;
				if (topRange < 8) topRange++;
			}
			capsules.add(new Capsule(caps, crit, 2 - caps.size()));
		}
	}

	private void createVerticalCapsules(int xPos) {
		int botRange = 1;
		int topRange = 5;
		for (int k = 1; k < 6; k++) {
			List<Node> caps = new LinkedList<Node>();
			List<Node> crit = new LinkedList<Node>();
			if (k == 1) {
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = dict.get(5) + Integer.toString(xPos);
							return node.getPos().equals(pos); 
						})
						.findFirst()
						.get()
				);
				for (int tempCap = botRange; tempCap < topRange; tempCap++) {
					final int capIt = tempCap;
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = dict.get(capIt) + Integer.toString(xPos);
								return node.getPos().equals(pos); 
							})
							.findFirst()
							.get()
					);
				}
				topRange++;
			} else if (k == 5) {
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = dict.get(4) + Integer.toString(xPos);
							return node.getPos().equals(pos); 
						})
						.findFirst()
						.get()
				);
				for (int tempCap = botRange + 1; tempCap <= topRange; tempCap++) {
					final int capIt = tempCap;
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = dict.get(capIt) + Integer.toString(xPos);
								return node.getPos().equals(pos); 
							})
							.findFirst()
							.get()
					);
				}
			} else {
				final int botNum = botRange;
				final int topNum = topRange;
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = dict.get(botNum) + Integer.toString(xPos);
							return node.getPos().equals(pos); 
						})
						.findFirst()
						.get()
				);
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = dict.get(topNum) + Integer.toString(xPos);
							return node.getPos().equals(pos); 
						})
						.findFirst()
						.get()
				);
				for (int tempCap = botRange + 1; tempCap < topRange; tempCap++) {
					final int capIt = tempCap;
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = dict.get(capIt) + Integer.toString(xPos);
								return node.getPos().equals(pos); 
							})
							.findFirst()
							.get()
					);
				}
				botRange++;
				if (topRange < 8) topRange++;
			}
			capsules.add(new Capsule(caps, crit, 2 - caps.size()));
		}
	}

  // TODO need to add depth param
	public boolean test(String pos, int player, int depth) {
		return nodes.stream().filter(node -> {
				return node.getPos().equals(pos);
			}).findFirst()
				.get()
				.test(player, depth);
	}

	public int getTotalTestValue(int depth) {
		int total = 0;
		for (Capsule capsul : capsules) {
			if (capsul.isTestAlive(depth)) total += capsul.getTestValue(depth);
		}
		return total;
	}

  public void rewindAll(int depth) {
		for (Capsule capsul : capsules) {
      capsul.alignTestToDepth(depth);
		}
    for (Node nod : nodes) {
      nod.alignTestToDepth(depth);
    }
  }
}
