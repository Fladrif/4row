public class TestCapsules {
	boolean alive;
	int owner;
  int capsPlayed;
  int critPlayed;
	int value;
  int depth;

  public TestCapsules(boolean alive, int owner, int capsPlayed, int critPlayed, int value, int depth) {
    this.alive = alive;
    this.owner = owner;
    this.capsPlayed = capsPlayed;
    this.critPlayed = critPlayed;
    this.value = value;
    this.depth = depth;
  }

  // SETTER
  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  public void setOwner(int owner) {
    this.owner = owner;
  }

  public void setCapsPlayed(int capsPlayed) {
    this.capsPlayed = capsPlayed;
  }

  public void setCritPlayed(int critPlayed) {
    this.critPlayed = critPlayed;
  }

  public void setValue(int value) {
    this.value = value;
  }

  // GETTER
  public int getCapsPlayed() {
    return this.capsPlayed;
  }

  public int getCritPlayed() {
    return this.critPlayed;
  }

  public boolean getAlive() {
    return this.alive;
  }

  public int getValue() {
    return this.value;
  }

  public int getOwner() {
    return this.value;
  }

  public int getDepth() {
    return depth;
  }
}
