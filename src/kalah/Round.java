package kalah;

import com.qualitascorpus.testsupport.IO;

public class Round {
	public void P1P2round(IO io, boolean vertical) {
		KalahBoard kalahBoard = new KalahBoard();
		KalahCases kalahCases = new KalahCases();
		kalahPromptGetInputCondition p1Prompt = new kalahPromptGetInputCondition();
		kalahPromptGetInputCondition p2Prompt = new kalahPromptGetInputCondition();
        MethodInRound mir12 = new MethodInRound();

		int[][] numberArray = mir12.createNumberArray(vertical);
		kalahBoard.printKalahBoard(io, numberArray);
		boolean finished = false; // Use with break; to exist for loop when within a while loop
		for (int round=0; round < 100000 && !finished; round++) {
			if (round % 2 == 0) { // P1 round
				int[] storeTotalNumberArr = kalahCases.gameFinishRoundOne(io, numberArray);
				if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
					break;
				}
				char inputChar = p1Prompt.p1Prompt(io);
				if (inputChar == 'q') {
					kalahCases.printGameOverAndBoard(io, kalahBoard, numberArray);
					break;
				}
				if (inputChar == '1' || inputChar == '2' || inputChar == '3' || inputChar == '4' || inputChar == '5' || inputChar == '6') {
					// do the move
					finished = mir12.regularMoveStepP1(io, kalahBoard, inputChar, numberArray);
				}
			}
			else if (round % 2 == 1) { //P2 round
				int[] storeTotalNumberArr = kalahCases.gameFinishRoundTwo(io, numberArray);
				if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
					break;
				}
				char inputChar = p2Prompt.p2Prompt(io);
				if (inputChar == 'q') {
					kalahCases.printGameOverAndBoard(io, kalahBoard, numberArray);
					break;
				}
				if (inputChar == '1' || inputChar == '2' || inputChar == '3' || inputChar == '4' || inputChar == '5' || inputChar == '6') {
					// do the move
					finished = mir12.regularMoveStepP2(io, kalahBoard, inputChar, numberArray);
				}
			}
		}
	}

	public void P1RobotRound(IO io, boolean vertical) {
		KalahBoard kalahBoard = new KalahBoard();
		KalahCases kalahCases = new KalahCases();
		kalahPromptGetInputCondition p1Prompt = new kalahPromptGetInputCondition();
		MethodInRound mir1R = new MethodInRound();

		int[][] numberArray = mir1R.createNumberArray(vertical);
		System.out.println("address of originalNA: " + numberArray);
		kalahBoard.printKalahBoard(io, numberArray);
		boolean finished = false; // Use with break; to exist for loop when within a while loop
		for (int round=0; round < 100000 && !finished; round++) {
			if (round % 2 == 0) { // P1 round
				int[] storeTotalNumberArr = kalahCases.gameFinishRoundOne(io, numberArray);
				if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
					break;
				}
				char inputChar = p1Prompt.p1Prompt(io);
				if (inputChar == 'q') {
					kalahCases.printGameOverAndBoard(io, kalahBoard, numberArray);
					break;
				}
				if (inputChar == '1' || inputChar == '2' || inputChar == '3' || inputChar == '4' || inputChar == '5' || inputChar == '6') {
					// do the move
					finished = mir1R.regularMoveStepP1(io, kalahBoard, inputChar, numberArray);
				}
				System.out.println("address of P1NA: " + numberArray);
			}
			else if (round % 2 == 1) { //robot round
				int[] storeTotalNumberArr = kalahCases.gameFinishRoundTwo(io, numberArray);
				if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
					break;
				}
				finished = mir1R.regularMoveStepRobot(io, kalahBoard, numberArray, false);
				
			}
		}
	}
}
