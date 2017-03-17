import java.util.*;

public class Adversarial {
	HashMap<Integer, String> dict = new HashMap<Integer, String>();

  public Adversarial() {
		dict.put(1, "A");
		dict.put(2, "B");
		dict.put(3, "C");
		dict.put(4, "D");
		dict.put(5, "E");
		dict.put(6, "F");
		dict.put(7, "G");
		dict.put(8, "H");
  }

  public String evaluate(Board board, int totalDepth) {
    ResponsePair pair = recursiveEval(board, 1, totalDepth);
    return pair.play;
    // int player = (totalDepth % 2 == 0) ? -1 : 1;
    // String bestPlay = "";
    // int best = 0;
    // for (int i = 1; i < 9; i++) {
    //   for (int j = 1; j < 9; j++) {
    //     String curPlay = dict.get(i) + Integer.toString(j);
    //     board.test(curPlay, player, totalDepth);
    //     int curVal = board.getTotalTestValue(totalDepth);
    //     if (curVal > best) {
    //       bestPlay = curPlay;
    //       best = curVal;
    //     }
    //     board.rewindAll(totalDepth - 1);
    //   }
    // }
    // return new ResponsePair(bestPlay, best);
  }

  private ResponsePair recursiveEval(Board board, int curDepth, int totalDepth) {
    int player = (curDepth % 2 == 0) ? -1 : 1;
    String bestPlay = "";
    int best = 0;
    if (curDepth < totalDepth) {
      for (int i = 1; i < 9; i++) {
        for (int j = 1; j < 9; j++) {
          String curPlay = dict.get(i) + Integer.toString(j);

          if (board.test(curPlay, player, curDepth)) {
            ResponsePair curPair = recursiveEval(board, curDepth + 1, totalDepth);
            if (bestPlay == "") {
              bestPlay = curPair.play;
              best = curPair.value;
            } else if (curPair.value * player > best * player) {
              bestPlay = curPair.play;
              best = curPair.value;
            }
            board.rewindAll(curDepth - 1);
          }
        }
      }
    } else {
      for (int i = 1; i < 9; i++) {
        for (int j = 1; j < 9; j++) {
          String curPlay = dict.get(i) + Integer.toString(j);

          if (board.test(curPlay, player, curDepth)) {
            int curVal = board.getTotalTestValue(curDepth);
            if (bestPlay == "") {
              bestPlay = curPlay;
              best = curVal;
            } else if (curVal * player > best * player) {
              bestPlay = curPlay;
              best = curVal;
            }
            board.rewindAll(curDepth - 1);
          }
        }
      }
    }
    return new ResponsePair(bestPlay, best);
  }
}


class ResponsePair {
  public String play;
  public int value;

  public ResponsePair(String play, int value) {
    this.play = play;
    this.value = value;
  }
}
