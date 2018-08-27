

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
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 11; i++) {
			sb.append("(" + Byte.toString(state[2 * i]) + ","
        + Byte.toString(state[2 * i + 1]) + ") ");

		}
		return sb.toString();
  }

}
