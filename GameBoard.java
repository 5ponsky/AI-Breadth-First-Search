


class GameBoard {
  public static boolean[][] board;

  GameBoard() {
    board = new boolean[10][10];
    init_board();
  }

  void init_board() {
    // true means that space is occupied or illegal
    for(int i = 0; i < board.length; ++i) {
      board[i][0] = true;
      board[i][9] = true;
      board[0][i] = true;
      board[9][i] = true;
    }

    // top left inner corner
    board[1][1] = true;
    board[1][2] = true;
    board[2][1] = true;

    // bottom left inner corner
    board[7][1] = true;
    board[8][1] = true;
    board[8][2] = true;

    // top right inner corner
    board[1][7] = true;
    board[1][8] = true;
    board[2][8] = true;

    // bottom right inner corner
    board[7][8] = true;
    board[8][7] = true;
    board[8][8] = true;

    // inner block
    board[4][3] = true;
    board[4][4] = true;
    board[3][4] = true;
  }

  boolean completed(GameState gs) {
    if(gs.state[1] == -2) {
      System.out.println("Solution found!");
      return true;
    }
    return false;
  }

  boolean isValid(byte[] state) {
    // test if each block fits according to its original posotion

    // Reset GameBoard
    reset();

    // Block 0
    if(board[3 + state[1]][1 + state[0]] == true) return false; else board[3 + state[1]][1 + state[0]] = true;
    if(board[4 + state[1]][1 + state[0]] == true) return false; else board[4 + state[1]][1 + state[0]] = true;
    if(board[3 + state[1]][2 + state[0]] == true) return false; else board[3 + state[1]][2 + state[0]] = true;
    if(board[4 + state[1]][2 + state[0]] == true) return false; else board[4 + state[1]][2 + state[0]] = true;

    // Block 1
    if(board[5 + state[3]][1 + state[2]] == true) return false; else board[5 + state[3]][1 + state[2]] = true;
    if(board[6 + state[3]][1 + state[2]] == true) return false; else board[6 + state[3]][1 + state[2]] = true;
    if(board[6 + state[3]][2 + state[2]] == true) return false; else board[6 + state[3]][2 + state[2]] = true;

    // Block 2
    if(board[5 + state[5]][2 + state[4]] == true) return false; else board[5 + state[5]][2 + state[4]] = true;
    if(board[5 + state[5]][3 + state[4]] == true) return false; else board[5 + state[5]][3 + state[4]] = true;
    if(board[6 + state[5]][3 + state[4]] == true) return false; else board[6 + state[5]][3 + state[4]] = true;

    // Block 3
    if(board[7 + state[7]][3 + state[6]] == true) return false; else board[7 + state[7]][3 + state[6]] = true;
    if(board[8 + state[7]][3 + state[6]] == true) return false; else board[8 + state[7]][3 + state[6]] = true;
    if(board[8 + state[7]][4 + state[6]] == true) return false; else board[8 + state[7]][4 + state[6]] = true;

    // Block 4
    if(board[7 + state[9]][4 + state[8]] == true) return false; else board[7 + state[9]][4 + state[8]] = true;
    if(board[7 + state[9]][5 + state[8]] == true) return false; else board[7 + state[9]][5 + state[8]] = true;
    if(board[8 + state[9]][5 + state[8]] == true) return false; else board[8 + state[9]][5 + state[8]] = true;

    // Block 5
    if(board[7 + state[11]][6 + state[10]] == true) return false; else board[7 + state[11]][6 + state[10]] = true;
    if(board[8 + state[11]][6 + state[10]] == true) return false; else board[8 + state[11]][6 + state[10]] = true;
    if(board[7 + state[11]][7 + state[10]] == true) return false; else board[7 + state[11]][7 + state[10]] = true;

    // Block 6
    if(board[4 + state[13]][5 + state[12]] == true) return false; else board[4 + state[13]][5 + state[12]] = true;
    if(board[5 + state[13]][4 + state[12]] == true) return false; else board[5 + state[13]][4 + state[12]] = true;
    if(board[5 + state[13]][5 + state[12]] == true) return false; else board[5 + state[13]][5 + state[12]] = true;
    if(board[6 + state[13]][5 + state[12]] == true) return false; else board[6 + state[13]][5 + state[12]] = true;

    // Block 7
    if(board[4 + state[15]][6 + state[14]] == true) return false; else board[4 + state[15]][6 + state[14]] = true;
    if(board[5 + state[15]][6 + state[14]] == true) return false; else board[5 + state[15]][6 + state[14]] = true;
    if(board[6 + state[15]][6 + state[14]] == true) return false; else board[6 + state[15]][6 + state[14]] = true;
    if(board[5 + state[15]][7 + state[14]] == true) return false; else board[5 + state[15]][7 + state[14]] = true;

    // Block 8
    if(board[6 + state[17]][7 + state[16]] == true) return false; else board[6 + state[17]][7 + state[16]] = true;
    if(board[6 + state[17]][8 + state[16]] == true) return false; else board[6 + state[17]][8 + state[16]] = true;
    if(board[5 + state[17]][8 + state[16]] == true) return false; else board[5 + state[17]][8 + state[16]] = true;

    // Block 9
    if(board[3 + state[19]][5 + state[18]] == true) return false; else board[3 + state[19]][5 + state[18]] = true;
    if(board[3 + state[19]][6 + state[18]] == true) return false; else board[3 + state[19]][6 + state[18]] = true;
    if(board[2 + state[19]][6 + state[18]] == true) return false; else board[2 + state[19]][6 + state[18]] = true;

    // Block 10
    if(board[2 + state[21]][5 + state[20]] == true) return false; else board[2 + state[21]][5 + state[20]] = true;
    if(board[1 + state[21]][5 + state[20]] == true) return false; else board[1 + state[21]][5 + state[20]] = true;
    if(board[1 + state[21]][6 + state[20]] == true) return false; else board[1 + state[21]][6 + state[20]] = true;

    return true;
  }

  void reset() {
    for(int i = 3; i < 7; ++i) {
      board[1][i] = false;
      board[8][i] = false;

      board[i][1] = false;
      board[i][8] = false;
    }

    for(int i = 2; i < 8; ++i) {
      for(int j = 2; j < 8; ++j) {
        board[i][j] = false;
      }
    }

    board[4][3] = true;
    board[4][4] = true;
    board[3][4] = true;

  }

}
