import java.util.Comparator;
import java.util.TreeSet;


class Main {


	public static void main(String[] args) {
		StateComparator comp = new StateComparator();
		TreeSet<GameState> set = new TreeSet<GameState>(comp);

		GameState a = new GameState(null);
		a.state[21] = 7;

		GameState b = new GameState(null);
		b.state[14] = 3;

		GameState c = new GameState(null);
		c.state[21] = 7;
		System.out.println(c.state[21]);

		if(!set.contains(a))
			System.out.println("Passed 1");
		else
			System.out.println("oops 1");
		set.add(a);

		if(set.contains(a))
			System.out.println("Passed 2");
		else
			System.out.println("oops 2");

		if(!set.contains(b))
			System.out.println("Passed 3");
		else
			System.out.println("oops 3");

		if(set.contains(c))
			System.out.println("Passed 4");
		else
			System.out.println("oops 4");
	}
}
