

class GameState {
  GameState prev;
  byte[] state;
  boolean[][] validity;

  // Have the gamestate be the action,
  // and the game board is the constraint on the actions
  GameState(GameState _prev) {
    prev = _prev;
    state = new byte[22];



    // // blank/starting board
    // if(_prev == null)
    //   init_board();

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

  boolean isValidMove() {
    return false;
  }



  // void printState() {
  //   for(int i = 0; i < validity.length; ++i) {
  //     for(int j = 0; j < validity[0].length; ++j){
  //       int bool = validity[i][j] ? 1 : 0;
  //       System.out.print(bool + "  ");
  //     }
  //     System.out.println("");
  //   }
  // }

}
