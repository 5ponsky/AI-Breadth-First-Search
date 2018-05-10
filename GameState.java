

class GameState {
  GameState prev;
  byte[] state;
  boolean[][] validity;

  GameState(GameState _prev) {
    prev = _prev;
    state = new byte[22];

    //
    validity = new boolean[10][10];

    // true means that space is occupied or illegal
    for(int i = 0; i < validity.length; ++i) {
      validity[i][0] = true;
      validity[i][9] = true;
      validity[0][i] = true;
      validity[9][i] = true;
    }

    // top left inner corner
    validity[1][1] = true;
    validity[1][2] = true;
    validity[2][1] = true;

    // bottom left inner corner
    validity[7][1] = true;
    validity[8][1] = true;
    validity[8][2] = true;

    // top right inner corner
    validity[1][7] = true;
    validity[1][8] = true;
    validity[2][8] = true;

    // bottom right inner corner
    validity[7][8] = true;
    validity[8][7] = true;
    validity[8][9] = true;

    // inner block
    validity[4][3] = true;
    validity[4][4] = true;
    validity[3][4] = true;
    printState();
  }

  static String stateToString(byte[] b) {
    StringBuilder sb = new StringBuilder();
    sb.append(Byte.toString(b[0]));

    for(int i = 1; i < b.length; ++i) {
      sb.append(",");
      sb.append(Byte.toString(b[i]));
    }

    return sb.toString();
  }

  void printState() {
    for(int i = 0; i < validity.length; ++i) {
      for(int j = 0; j < validity[0].length; ++j){
        int bool = validity[i][j] ? 1 : 0;
        System.out.print(bool + "  ");
      }
      System.out.println("");
    }
  }
}
