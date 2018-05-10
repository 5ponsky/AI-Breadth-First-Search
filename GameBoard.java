


class GameBoard {
  public static boolean[][] constraints;

  GameBoard() {
    constraints = new boolean[10][10];

    init_board();
  }

  void init_board() {
    // true means that space is occupied or illegal
    for(int i = 0; i < constraints.length; ++i) {
      constraints[i][0] = true;
      constraints[i][9] = true;
      constraints[0][i] = true;
      constraints[9][i] = true;
    }

    // top left inner corner
    constraints[1][1] = true;
    constraints[1][2] = true;
    constraints[2][1] = true;

    // bottom left inner corner
    constraints[7][1] = true;
    constraints[8][1] = true;
    constraints[8][2] = true;

    // top right inner corner
    constraints[1][7] = true;
    constraints[1][8] = true;
    constraints[2][8] = true;

    // bottom right inner corner
    constraints[7][8] = true;
    constraints[8][7] = true;
    constraints[8][9] = true;

    // inner block
    constraints[4][3] = true;
    constraints[4][4] = true;
    constraints[3][4] = true;
  }

}
