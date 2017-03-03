public class Node {
	Capsule[] capsul;
	String pos;
	boolean played;
	int player;

	public Node(String pos) {
		this.pos = pos;
		this.player = 0;
		this.played = false;
	}

	public void addCap(Capsule cap) {
		Capsule[] newCapsul = new Capsule[capsul.length + 1];
		for (int i = 0; i < capsul.length; i++) {
			newCapsul[i] = capsul[i];
		}
		newCapsul[newCapsul.length - 1] = cap;
		capsul = newCapsul;
	}

	public void play(int player) {
		this.player = player;
		this.played = true;
		for (int i = 0; i < capsul.length; i++) {
			capsul[i].makeMove(this.pos, player);
		}
	}

	public int getPlayer() {
		return player;
	}

	public String getPos() {
		return pos;
	}
}
