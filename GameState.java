

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

    if(_prev != null) {
      for(int i = 0; i < state.length; ++i)
        this.state[i] = prev.state[i];
    }
    // blank/starting board (That is, if we are at the root)

    // } else {
    //   for(int i = 0; i < state.length; ++i)
    //     this.state[i] = prev.state[i];
    //
    //   for(int i = 0; i < constraints.length; ++i) {
    //     for(int j = 0; j < constraints[i].length; ++j) {
    //       this.constraints[i][j] = prev.constraints[i][j];
    //     }
    //   }
    //
    // }

  }

}
