

class GameState {
  GameState prev;
  byte[] state;

  GameState(GameState _prev) {
    prev = _prev;
    state = new byte[22];
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
}
