package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;

/**
 * This class is the starting point for a Kalah implementation using
 * the test infrastructure. Remove this comment (or rather, replace it
 * with something more appropriate)
 */

public class Kalah {
	public static void main(String[] args) {
		new Kalah().play(new MockIO(), false, false);
	}

	/**
	 * Play a game of Kalah.
	 * @param io There to get input from and direct output to
	 * @param vertical If true, then play the game between two humans but orient the board vertically.
	 * If it is false <b>and</b> bmf is false then orient the board horizontally.
	 * @param bmf If vertical if false <b>and</b> this is true then play the game where the second player
	 * (P2) is the "best first move" robot.
	 */
	public void play(IO io, boolean vertical, boolean bmf) {
		// Replace what's below with your implementation
		//io.println("+----+-------+-------+-------+-------+-------+-------+----+");
		//io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");
		//io.println("|    |-------+-------+-------+-------+-------+-------|    |");
		//io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
		//io.println("+----+-------+-------+-------+-------+-------+-------+----+");
		//io.println("Player 1's turn - Specify house number or 'q' to quit: ");
		Round round12 = new Round();
		Round round1R = new Round();
		if (vertical == true) {
			// p1, p2, board vertical
			round12.P1P2round(io, vertical);
		}
		else if ((vertical == false) && (bmf == false)) {
			// p1, p2, board horizontal
			round12.P1P2round(io, vertical);
		}
		else if ((vertical == false) && (bmf == true)) {
			// p1, robot, board horizontal
			round1R.P1RobotRound(io, vertical);
		}
	}
}
