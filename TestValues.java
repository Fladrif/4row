import java.util.*;

public class TestValues {
	boolean alive;
	int owner;
  int capsPlayed;
  int critPlayed;
	int value;
  int depth;

  public TestValues(boolean alive, int owner, int capsPlayed, int critPlayed, int value, int depth) {
    this.alive = alive;
    this.owner = owner;
    this.capsPlayed = capsPlayed;
    this.critPlayed = critPlayed;
    this.value = value;
    this.depth = depth;
  }
}
