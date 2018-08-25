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

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings("serial")
class View extends JPanel implements MouseListener {
	Viz viz;
	Random rand;
	Graphics graphics;
	int size;
	boolean[][] constraints;
	GameState gs;
	GameBoard gb;
	StateComparator comp;
	TreeSet<GameState> set;


	View(Viz v) throws IOException {
		viz = v;
		rand = new Random(3);
		size = 48;
		gs = new GameState(null);
		gb = new GameBoard();

		comp = new StateComparator();
		set = new TreeSet<GameState>(comp);

		// for(int i = 0; i < gb.board.length; ++i) {
		// 	for(int j = 0; j < gb.board[i].length; ++j) {
		// 		System.out.print((gb.board[i][j]?1:0) + " ");
		// 	}
		// 	System.out.println();
		// }
		// System.out.println("=============================================");
	}

	public void mousePressed(MouseEvent e) {
		GameState _gs = new GameState(gs);

		for(int i = 0; i < 22; ++i) {
			_gs.state[i] += 1;
			if(gb.isValid(_gs.state) == 666 && !set.contains(_gs))
				break;

			_gs.state[i] += -2;
			if(gb.isValid(_gs.state) == 666 && !set.contains(_gs))
				break;

			_gs.state[i] += 1;
		}
		set.add(_gs);

		gs = new GameState(_gs);


		for(int i = 0; i < 11; i++)
		System.out.print("(" + gs.state[2 * i] + "," +
			gs.state[2 * i + 1] + ") ");
		System.out.println();

		viz.repaint();

		// for(int i = 0; i < gb.board.length; ++i) {
		// 	for(int j = 0; j < gb.board[i].length; ++j) {
		// 		System.out.print((gb.board[i][j]?1:0) + " ");
		// 	}
		// 	System.out.println();
		// }
		// System.out.println("=============================================");
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
		b(gs.state[2 * id] + x1, gs.state[2 * id + 1] + y1);
		b(gs.state[2 * id] + x2, gs.state[2 * id + 1] + y2);
		b(gs.state[2 * id] + x3, gs.state[2 * id + 1] + y3);
	}

	// Draw a 4-block piece
	public void shape(int id, int red, int green, int blue, int x1, int y1,
		int x2, int y2, int x3, int y3, int x4, int y4) {

		shape(id, red, green, blue, x1, y1, x2, y2, x3, y3);
		b(gs.state[2 * id] + x4, gs.state[2 * id + 1] + y4);
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
