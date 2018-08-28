import java.io.PrintWriter;
import java.io.IOException;
import java.lang.StringBuffer;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;
import java.util.LinkedList;

class Main {



	public static void buildGraph() {
		// Empty set set S
		StateComparator comp = new StateComparator();
		TreeSet<GameState> set = new TreeSet<GameState>(comp);

		GameBoard gb = new GameBoard();

		// Empty Queue Q (Stack?)
		LinkedList<GameState> queue = new LinkedList<GameState>();

		GameState root = new GameState(null);
		set.add(root);
		queue.push(root);

		//Iterator<GameState> itr = queue.iterator();

		int x = 0;
		boolean done = false;
		GameState current = root;
		while(!done) {
			current = queue.poll();

			// Check if this state is the completed one
			if(gb.completed(current)) {
				break;
			}

			GameState newState;
			for(int i = 0; i < 22; ++i) {
				newState = new GameState(current);

				newState.state[i] += 1;
				if(gb.isValid(newState.state) && !set.contains(newState)) {
					set.add(newState);
					queue.add(newState);
					newState = new GameState(current);
				} else
					newState.state[i] += -1;

				newState.state[i] += -1;
				if(gb.isValid(newState.state) && !set.contains(newState)) {
					set.add(newState);
					queue.add(newState);
				}
			}

			++x;
			//if(x > 500) done = true;
		}
		writeSolution(current);


		//
		// for(GameState g : set) {
		// 	System.out.println(g.toString());
		// }

	}

	public static void writeSolution(GameState last) {
		Stack<GameState> stack = new Stack<GameState>();

		GameState current = last;
		while(current != null) {
			stack.push(current);
			current = current.prev;
		}

		StringBuffer sb = new StringBuffer();
		int x = 0;

		boolean visualizer = false; // set to true to visualize the solution set
		if(!visualizer) {
			while(!stack.empty()) {
				sb.append(stack.pop().toString() + '\n');
				//++x
			}

			try {
				PrintWriter out = new PrintWriter("results.txt");
				out.println(sb);
				out.close();
			} catch(IOException e) { e.printStackTrace(); }

		} else {
			try { new Viz(stack); } catch(Exception e) {}
		}

		System.out.println(sb);
	}


	public static void main(String[] args) {
		buildGraph();

		// StateComparator comp = new StateComparator();
		// TreeSet<GameState> set = new TreeSet<GameState>(comp);
		//
		// GameState a = new GameState(null);
		// a.state[21] = 7;
		//
		// GameState b = new GameState(null);
		// b.state[14] = 3;
		//
		// GameState c = new GameState(a);
		// c.state[21] = 7;
		//
		// GameState d = new GameState(c);
		// d.state[21] = 7;
		//
		// if(!set.contains(a))
		// 	System.out.println("Passed 1");
		// else
		// 	System.out.println("oops 1");
		// set.add(a);
		//
		// if(set.contains(d))
		// 	System.out.println("Passed 2");
		// else
		// 	System.out.println("oops 2");
		//
		// if(!set.contains(b))
		// 	System.out.println("Passed 3");
		// else
		// 	System.out.println("oops 3");
		//
		// if(!set.contains(c))
		// 	System.out.println("Passed 4");
		// else
		// 	System.out.println("oops 4");
	}
}
