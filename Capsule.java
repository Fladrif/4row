import java.util.*;

public class Capsule implements Cloneable{
	List<Node> caps = new LinkedList<Node>();
	List<Node> crit = new LinkedList<Node>();
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
		if (alive) calculateVal();
	}

	// TODO rewrite to have test values persist in Capsule
	public void testMove(String pos, int player) {
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
		if (alive) calculateVal();
	}

	private void calculateVal() {
		switch (capsPlayed) {
			case 0:
				switch (critPlayed) {
					case 0:
						value = 5 * owner;
						break;
					case 1:
						value = 12 * owner;
						break;
					case 2:
						value = 40 * owner;
						break;
					case 3:
						value = 40 * owner;
				}
				break;
			case 1:
				switch (critPlayed) {
					case 0:
						value = 3 * owner;
						break;
					case 1:
						value = 4 * owner;
						break;
					case 2:
						value = 10 * owner;
						break;
					case 3:
						value = 40 * owner;
				}
				break;
			case 2:
				switch (critPlayed) {
					case 0:
						value = 1 * owner;
						break;
					case 1:
						value = 3 * owner;
						break;
					case 2:
						value = 8 * owner;
						break;
					case 3:
						value = 40 * owner;
				}
		}
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

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
