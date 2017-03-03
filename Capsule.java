import java.util.*;

public class Capsule {
	List<Node> caps;
	List<Node> crit;
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
	}

	public void makeMove(String pos, int player) {
		if (owner == 0) owner = player;
		Node cap = caps.stream()
			.filter(node -> node.getPos() == pos)
			.findFirst().orElse(null);
		if (cap != null) {
			capsPlayed += cap.getPlayer() != owner ? 1 : 0;
		}
		Node cri = crit.stream()
			.filter(node -> node.getPos() == pos)
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
		if (alive) return -1;
		return value;
	}
}
