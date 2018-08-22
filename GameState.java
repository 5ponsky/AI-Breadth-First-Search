

class GameState {
  GameState prev;
  byte[] state;
  boolean[][] constraints;

  // Have the gamestate be the action,
  // and the game board is the constraint on the actions
  GameState(GameState _prev) {
    prev = _prev;

    // There are 11 pieces, each with an (x,y) coordinate pair
    // So each byte represents one coordinate of each piece
    state = new byte[22];
    constraints = new boolean[10][10];

    // blank/starting board (That is, if we are at the root)
    if(_prev == null) {
      init_board();
    } else {
      for(int i = 0; i < state.length; ++i)
        this.state[i] = prev.state[i];

      for(int i = 0; i < constraints.length; ++i) {
        for(int j = 0; j < constraints[i].length; ++j) {
          this.constraints[i][j] = prev.constraints[i][j];
        }
      }

    }

  }

  // Transform the state by moving a block a single step in a direction
  boolean validState(int coordinateIndex, int move) {
    /// Since each coordinate of a piece is its location
    /// Relative to its initial position, then it would
    /// Be intuitive to translate a block's boolean "shape"
    /// By those transformations

    if(coordinateIndex == 0) {
      // Is moving piece 0 left or right bad?
      if(constraints[3][1 + move] == true) return false;
      if(constraints[3][2 + move] == true) return false;
      if(constraints[4][1 + move] == true) return false;
      if(constraints[4][2 + move] == true) return false;
      constraints[3][1 + move] = constraints[3][2 + move] = constraints[4][1 + move] = constraints[4][2 + move] = true;
    } else if(coordinateIndex == 1) {
      // Is moving piece 0 up or down bad?
      if(constraints[3 + move][1] == true) return false;
      if(constraints[3 + move][2] == true) return false;
      if(constraints[4 + move][1] == true) return false;
      if(constraints[4 + move][2] == true) return false;
      constraints[3 + move][1] = constraints[3 + move][2] = constraints[4 + move][1] = constraints[4 + move][2] = true;
    } else if(coordinateIndex == 2) {
      // Is moving piece 1 left or right bad?
      if(constraints[5][1 + move] == true) return false;
      if(constraints[6][1 + move] == true) return false;
      if(constraints[6][2 + move] == true) return false;
      constraints[5][1 + move] = constraints[6][1 + move] = constraints[6][2 + move] = true;
    } else if(coordinateIndex == 3) {
      // Is moving piece 1 up or down bad?
      if(constraints[5 + move][1] == true) return false;
      if(constraints[6 + move][1] == true) return false;
      if(constraints[6 + move][2] == true) return false;
      constraints[5 + move][1] = constraints[6 + move][1] = constraints[6 + move][2] = true;
    } else if(coordinateIndex == 4) { /// HERE
      // Is moving piece 2 left or right bad?
      if(constraints[5][2 + move] == true) return false;
      if(constraints[5][3 + move] == true) return false;
      if(constraints[6][3 + move] == true) return false;
      constraints[5][2 + move] = constraints[5][3 + move] = constraints[6][3 + move] = true;
    } else if(coordinateIndex == 5) {
      // Is moving piece 2 up or down bad?


      if(constraints[5 + move][2] == true) return false;
      if(constraints[5 + move][3] == true) return false;
      if(constraints[6 + move][3] == true) return false;
      constraints[5 + move][2] = constraints[5 + move][3] = constraints[6 + move][3] = true;
    } else if(coordinateIndex == 6) {
      // Is moving piece 3 left or right bad?
      if(constraints[7][3 + move] == true) return false;
      if(constraints[8][3 + move] == true) return false;
      if(constraints[8][4 + move] == true) return false;
      constraints[7][3 + move] = constraints[8][3 + move] = constraints[8][4 + move] = true;
    } else if(coordinateIndex == 7) {
      // Is moving piece 3 up or down bad?


      if(constraints[7 + move][3] == true) return false;
      if(constraints[8 + move][3] == true) return false;
      if(constraints[8 + move][4] == true) return false;
      constraints[7 + move][3] = constraints[8 + move][3] = constraints[8 + move][4] = true;
    } else if(coordinateIndex == 8) {
      // Is moving piece 4 left or right bad?
      if(constraints[7][4 + move] == true) return false;
      if(constraints[7][5 + move] == true) return false;
      if(constraints[8][5 + move] == true) return false;
      constraints[7][4 + move] = constraints[7][5 + move] = constraints[8][5 + move] = true;
    } else if(coordinateIndex == 9) {
      // Is moving piece 4 up or down bad?

      if(constraints[7 + move][4] == true) return false;
      if(constraints[7 + move][5] == true) return false;
      if(constraints[8 + move][5] == true) return false;
      constraints[7 + move][4] = constraints[7 + move][5] = constraints[8 + move][5] = true;
    } else if(coordinateIndex == 10) {
      // Is moving piece 5 left or right bad?
      if(constraints[7][6 + move] == true) return false;
      if(constraints[8][6 + move] == true) return false;
      if(constraints[7][7 + move] == true) return false;
      constraints[7][6 + move] = constraints[8][6 + move] = constraints[7][7 + move] = true;
    } else if(coordinateIndex == 11) {
      // Is moving piece 5 up or down bad?

      if(constraints[7 + move][6] == true) return false;
      if(constraints[8 + move][6] == true) return false;
      if(constraints[7 + move][7] == true) return false;
      constraints[7 + move][6] = constraints[8 + move][6] = constraints[7 + move][7] = true;
    } else if(coordinateIndex == 12) {
      // Is moving piece 6 left or right bad?
      if(constraints[5][4 + move] == true) return false;
      if(constraints[4][5 + move] == true) return false;
      if(constraints[5][5 + move] == true) return false;
      if(constraints[6][5 + move] == true) return false;
      constraints[5][4 + move] = constraints[4][5 + move] = constraints[5][5 + move] = constraints[6][5 + move] = true;
    } else if(coordinateIndex == 13) {
      // is moving piece 6 up or down bad?


      if(constraints[5 + move][4] == true) return false;
      if(constraints[4 + move][5] == true) return false;
      if(constraints[5 + move][5] == true) return false;
      if(constraints[6 + move][5] == true) return false;
      constraints[5 + move][4] = constraints[4 + move][5] = constraints[5 + move][5] = constraints[6 + move][5] = true;
    } else if(coordinateIndex == 14) {
      // is moving piece 7 left or right bad?
      if(constraints[4][6 + move] == true) return false;
      if(constraints[5][6 + move] == true) return false;
      if(constraints[6][6 + move] == true) return false;
      if(constraints[5][7 + move] == true) return false;
      constraints[4][6 + move] = constraints[5][6 + move] = constraints[6][6 + move] = constraints[5][7 + move] = true;
    } else if(coordinateIndex == 15) {
      // is moving piece 7 up or down bad?


      if(constraints[4 + move][6] == true) return false;
      if(constraints[5 + move][6] == true) return false;
      if(constraints[6 + move][6] == true) return false;
      if(constraints[5 + move][7] == true) return false;
      constraints[4 + move][6] = constraints[5 + move][6] = constraints[6 + move][6] = constraints[5 + move][7] = true;
    } else if(coordinateIndex == 16) {
      // is moving piece 8 left or right bad?
      if(constraints[5][8 + move] == true) return false;
      if(constraints[6][7 + move] == true) return false;
      if(constraints[6][8 + move] == true) return false;
      constraints[5][8 + move] = constraints[6][7 + move] = constraints[6][8 + move] = true;
    } else if(coordinateIndex == 17) {
      // is moving piece 8 up or down bad?


      if(constraints[5 + move][8] == true) return false;
      if(constraints[6 + move][7] == true) return false;
      if(constraints[6 + move][8] == true) return false;
      constraints[5 + move][8] = constraints[6 + move][7] = constraints[6 + move][8] = true;
    } else if(coordinateIndex == 18) {
      // is moving piece 9 left or right bad?
      if(constraints[3][5 + move] == true) return false;
      if(constraints[3][6 + move] == true) return false;
      if(constraints[2][6 + move] == true) return false;
      constraints[3][5 + move] = constraints[3][6 + move] = constraints[2][6 + move] = true;
    } else if(coordinateIndex == 19) {
      // is moving piece 9 up or down bad?


      if(constraints[3 + move][5] == true) return false;
      if(constraints[3 + move][6] == true) return false;
      if(constraints[2 + move][6] == true) return false;
      constraints[3 + move][5] = constraints[3 + move][6] = constraints[2 + move][6] = true;
    } else if(coordinateIndex == 20) {
      // is moving piece 10 left or right bad?
      if(constraints[2][5 + move] == true) return false;
      if(constraints[1][5 + move] == true) return false;
      if(constraints[1][6 + move] == true) return false;
      constraints[2][5 + move] = constraints[1][5 + move] = constraints[1][6 + move] = true;
    } else if(coordinateIndex == 21) {
      // is moving piece 10 up or down bad?


      if(constraints[2 + move][5] == true) return false;
      if(constraints[1 + move][5] == true) return false;
      if(constraints[1 + move][6] == true) return false;
      constraints[2 + move][5] = constraints[1 + move][5] = constraints[1 + move][6] = true;
    }
    return true;
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

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Byte.toString(this.state[0]));

    for(int i = 1; i < this.state.length; ++i) {
      sb.append(",");
      sb.append(Byte.toString(this.state[i]));
    }

    return sb.toString();
  }

  boolean isValidMove() {
    return false;
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
    constraints[8][8] = true;

    // inner block
    constraints[4][3] = true;
    constraints[4][4] = true;
    constraints[3][4] = true;

    block0(true, 0, 0);
    block1(true, 0, 0);
    block2(true, 0, 0);
    block3(true, 0, 0);
    block4(true, 0, 0);
    block5(true, 0, 0);
    block6(true, 0, 0);
    block7(true, 0, 0);
    block8(true, 0, 0);
    block9(true, 0, 0);
    block10(true, 0, 0);
  }

  void block0(boolean flag, int x, int y) {
    constraints[3 + y][1 + x] = flag;
    constraints[3 + y][2 + x] = flag;
    constraints[4 + y][1 + x] = flag;
    constraints[4 + y][2 + x] = flag;
  }

  void block1(boolean flag, int x, int y) {
    constraints[5 + y][1 + x] = flag;
    constraints[6 + y][2 + x] = flag;
    constraints[6 + y][2 + x] = flag;
  }

  void block2(boolean flag, int x, int y) {
    constraints[5 + y][2 + x] = flag;
    constraints[5 + y][3 + x] = flag;
    constraints[6 + y][3 + x] = flag;
  }

  void block3(boolean flag, int x, int y) {
    constraints[7 + y][3 + x] = flag;
    constraints[8 + y][3 + x] = flag;
    constraints[8 + y][4 + x] = flag;
  }

  void block4(boolean flag, int x, int y) {
    constraints[7 + y][4 + x] = flag;
    constraints[7 + y][5 + x] = flag;
    constraints[8 + y][5 + x] = flag;
  }

  void block5(boolean flag, int x, int y) {
    constraints[7 + y][6 + x] = flag;
    constraints[8 + y][6 + x] = flag;
    constraints[7 + y][7 + x] = flag;
  }

  void block6(boolean flag, int x, int y) {
    constraints[5 + y][4 + x] = flag;
    constraints[4 + y][5 + x] = flag;
    constraints[5 + y][5 + x] = flag;
    constraints[6 + y][5 + x] = flag;
  }

  void block7(boolean flag, int x, int y) {
    constraints[4 + y][6 + x] = flag;
    constraints[5 + y][6 + x] = flag;
    constraints[6 + y][6 + x] = flag;
    constraints[5 + y][7 + x] = flag;
  }

  void block8(boolean flag, int x, int y) {
    constraints[5 + y][4 + x] = flag;
    constraints[4 + y][5 + x] = flag;
    constraints[5 + y][5 + x] = flag;
    constraints[6 + y][5 + x] = flag;
  }

  void block9(boolean flag, int x, int y) {
    constraints[3 + y][5 + x] = flag;
    constraints[2 + y][6 + x] = flag;
    constraints[3 + y][6 + x] = flag;
  }

  void block10(boolean flag, int x, int y) {
    constraints[1 + y][5 + x] = flag;
    constraints[2 + y][5 + x] = flag;
    constraints[1 + y][6 + x] = flag;
  }

}
