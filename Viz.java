import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Color;

@SuppressWarnings("serial")
class View extends JPanel implements MouseListener {
	Viz viz;
	Random rand;
	byte[] state;
	Graphics graphics;
	int size;
	boolean[][] constraints;

	View(Viz v) throws IOException {
		viz = v;
		rand = new Random(0);
		state = new byte[22];
		size = 48;
		constraints = new boolean[10][10];
		init_board();
	}

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



	public void mousePressed(MouseEvent e) {
		// How to transform state
		int choice = rand.nextInt(22);
		int move = rand.nextInt(2)  == 0 ? -1 : 1;
		if(validState(choice, move))
			state[choice] += (move);

		// Valid move logic here


		for(int i = 0; i < 11; i++)
		System.out.print("(" + state[2 * i] + "," +
			state[2 * i + 1] + ") ");
		System.out.println();

		viz.repaint();

		for(int i = 0; i < constraints.length; ++i) {
			for(int j = 0; j < constraints[i].length; ++j) {
				System.out.print(constraints[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void mouseReleased(MouseEvent e) {    }
	public void mouseEntered(MouseEvent e) {    }
	public void mouseExited(MouseEvent e) {    }
	public void mouseClicked(MouseEvent e) {    }

	// Draw a block
	public void b(int x, int y) {
		graphics.fillRect(size * x, size * y, size, size);
	}

	// Draw a 3-block piece
	public void shape(int id, int red, int green, int blue,
		int x1, int y1, int x2, int y2, int x3, int y3) {
		graphics.setColor(new Color(red, green, blue));
		b(state[2 * id] + x1, state[2 * id + 1] + y1);
		b(state[2 * id] + x2, state[2 * id + 1] + y2);
		b(state[2 * id] + x3, state[2 * id + 1] + y3);
	}

	// Draw a 4-block piece
	public void shape(int id, int red, int green, int blue, int x1, int y1,
		int x2, int y2, int x3, int y3, int x4, int y4) {

		shape(id, red, green, blue, x1, y1, x2, y2, x3, y3);
		b(state[2 * id] + x4, state[2 * id + 1] + y4);
	}

	public void paintComponent(Graphics g) {
		// Draw the black squares
		graphics = g;
		g.setColor(new Color(0, 0, 0));
		for(int i = 0; i < 10; i++) { b(i, 0); b(i, 9); }
		for(int i = 1; i < 9; i++) { b(0, i); b(9, i); }
		b(1, 1); b(1, 2); b(2, 1);
		b(7, 1); b(8, 1); b(8, 2);
		b(1, 7); b(1, 8); b(2, 8);
		b(8, 7); b(7, 8); b(8, 8);
		b(3, 4); b(4, 4); b(4, 3);

		// Draw the pieces
		shape(0, 255, 0, 0, 1, 3, 2, 3, 1, 4, 2, 4);
		shape(1, 0, 255, 0, 1, 5, 1, 6, 2, 6);
		shape(2, 128, 128, 255, 2, 5, 3, 5, 3, 6);
		shape(3, 255, 128, 128, 3, 7, 3, 8, 4, 8);
		shape(4, 255, 255, 128, 4, 7, 5, 7, 5, 8);
		shape(5, 128, 128, 0, 6, 7, 7, 7, 6, 8);
		shape(6, 0, 128, 128, 5, 4, 5, 5, 5, 6, 4, 5);
		shape(7, 0, 128, 0, 6, 4, 6, 5, 6, 6, 7, 5);
		shape(8, 0, 255, 255, 8, 5, 8, 6, 7, 6);
		shape(9, 0, 0, 255, 6, 2, 6, 3, 5, 3);
		shape(10, 255, 128, 0, 5, 1, 6, 1, 5, 2);
	}
}

@SuppressWarnings("serial")
public class Viz extends JFrame {

	public Viz() throws Exception {
		View view = new View(this);
		view.addMouseListener(view);
		this.setTitle("Puzzle");
		this.setSize(482, 505);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		new Viz();
	}
}
