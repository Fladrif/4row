import java.util.*;

public class Board {
	List<Node> nodes = new LinkedList<Node>();
	List<Capsule> capsules = new LinkedList<Capsule>();
	Hash<Integer, String> dict = new HashMap<Integer, String>();

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
			List<Node> caps;
			List<Node> crit;
			if (k == 1) {
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = yPos + "5";
							return node.getPos() == pos; 
						})
						.findFirst()
						.get()
				);
				for (int capIt = botRange; capIt < topRange; capIt++) {
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = yPos + Integer.toString(capIt);
								return node.getPos() == pos; 
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
							return node.getPos() == pos; 
						})
						.findFirst()
						.get()
				);
				for (int capIt = botRange + 1; capIt <= topRange; capIt++) {
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = yPos + Integer.toString(capIt);
								return node.getPos() == pos; 
							})
							.findFirst()
							.get()
					);
				}
			} else {
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = yPos + Integer.toString(botRange);
							return node.getPos() == pos; 
						})
						.findFirst()
						.get()
				);
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = yPos + Integer.toString(topRange);
							return node.getPos() == pos; 
						})
						.findFirst()
						.get()
				);
				for (int capIt = botRange + 1; capIt < topRange; capIt++) {
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = yPos + Integer.toString(capIt);
								return node.getPos() == pos; 
							})
							.findFirst()
							.get()
					);
				}
				botRange++;
				topRange++;
			}
			capsules.add(new Capsule(caps, crit, 2 - caps.size()));
		}
	}

	private void createVerticalCapsules(int xPos) {
		int botRange = 1;
		int topRange = 5;
		for (int k = 1; k < 6; k++) {
			List<Node> caps;
			List<Node> crit;
			if (k == 1) {
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = dict.get(5) + Integer.toString(xPos);
							return node.getPos() == pos; 
						})
						.findFirst()
						.get()
				);
				for (int capIt = botRange; capIt < topRange; capIt++) {
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = dict.get(capIt) + Integer.toString(xPos);
								return node.getPos() == pos; 
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
							return node.getPos() == pos; 
						})
						.findFirst()
						.get()
				);
				for (int capIt = botRange + 1; capIt <= topRange; capIt++) {
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = dict.get(capIt) + Integer.toString(xPos);
								return node.getPos() == pos; 
							})
							.findFirst()
							.get()
					);
				}
			} else {
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = dict.get(botRange) + Integer.toString(xPos);
							return node.getPos() == pos; 
						})
						.findFirst()
						.get()
				);
				caps.add(
						nodes
						.stream()
						.filter(node -> {
							String pos = dict.get(topRange) + Integer.toString(xPos);
							return node.getPos() == pos; 
						})
						.findFirst()
						.get()
				);
				for (int capIt = botRange + 1; capIt < topRange; capIt++) {
					crit.add(
							nodes
							.stream()
							.filter(node -> {
								String pos = dict.get(capIt) + Integer.toString(xPos);
								return node.getPos() == pos; 
							})
							.findFirst()
							.get()
					);
				}
				botRange++;
				topRange++;
			}
			capsules.add(new Capsule(caps, crit, 2 - caps.size()));
		}
	}
}
