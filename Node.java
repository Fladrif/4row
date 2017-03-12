import java.util.*;

public class Node implements Cloneable{
	List<Capsule> capsules = new LinkedList<Capsule>();
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

	public boolean test(int player) {
		if (played) return false;
		for (Capsule capsul : capsules) {
			capsul.testMove(this.pos, player);
		}
		return true;
	}

	public int getPlayer() {
		return player;
	}

	public String getPos() {
		return pos;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
