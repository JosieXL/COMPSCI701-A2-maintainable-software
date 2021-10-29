package kalah;

import com.qualitascorpus.testsupport.IO;

public class MethodInRound {
    public int[][] createNumberArrayOriginal() {
        // This is the initial state of Kalah board but in array
        int p1HouseOneSeedNumber = 4, p1HouseTwoSeedNumber = 4, p1HouseThreeSeedNumber = 4, p1HouseFourSeedNumber = 4, p1HouseFiveSeedNumber = 4, p1HouseSixSeedNumber = 4;
        int p2HouseOneSeedNumber = 4, p2HouseTwoSeedNumber = 4, p2HouseThreeSeedNumber = 4, p2HouseFourSeedNumber = 4, p2HouseFiveSeedNumber = 4, p2HouseSixSeedNumber = 4;
        int p1StoreNumber = 0, p2StoreNumber = 0;
        int[] p1NumberArray = {p1HouseOneSeedNumber, p1HouseTwoSeedNumber, p1HouseThreeSeedNumber, p1HouseFourSeedNumber, p1HouseFiveSeedNumber, p1HouseSixSeedNumber, p1StoreNumber};
        int[] p2NumberArray = {p2HouseOneSeedNumber, p2HouseTwoSeedNumber, p2HouseThreeSeedNumber, p2HouseFourSeedNumber, p2HouseFiveSeedNumber, p2HouseSixSeedNumber, p2StoreNumber};
		int[][] numberArray = {p1NumberArray, p2NumberArray};
		return numberArray;
	}

	public int[][] createNumberArray(boolean vertical) {
		int[][] numberArrayOriginal = createNumberArrayOriginal();
		int[][] numberArray;
		if (vertical == true) {
			numberArray =  new int[][] {numberArrayOriginal[0], numberArrayOriginal[1], {1}};
		}
		else {
			numberArray = new int[][] {numberArrayOriginal[0], numberArrayOriginal[1], {0}};
		}
		return numberArray;
	}

	public boolean collectSeedZeroCaseBooleanOne(IO io, int collectSeedFromHouse, char inputChar, int[][] numberArray) {
		boolean finished = false;
		KalahCases kalahCases = new KalahCases();
		if (collectSeedFromHouse == 0) {
			finished = kalahCases.seedIsZeroPlayerOne(io, inputChar, numberArray, collectSeedFromHouse);
		}
		return finished;
	}

	public boolean collectSeedZeroCaseBooleanTwo(IO io, int collectSeedFromHouse, char inputChar, int[][] numberArray) {
		boolean finished = false;
		KalahCases kalahCases = new KalahCases();
		if (collectSeedFromHouse == 0) {
			finished = kalahCases.seedIsZeroPlayerTwo(io, inputChar, numberArray, collectSeedFromHouse);
		}
		return finished;
	}

	public int getCollectSeedFromInputChar (char inputChar, int[] pNumberArray) {
		// Convert char to int
		int inputInt = inputChar - '0';
        int collectSeedFromHouse = pNumberArray[inputInt-1];
		return collectSeedFromHouse;
	}

	public boolean finalMoveAtStoreP1 (IO io, KalahBoard kalahBoard, int finalMoveIndex, int[][] numberArray) {
		boolean finished = false;
		KalahCases kalahCases = new KalahCases();
		Player playerOne = new Player();
		kalahPromptGetInputCondition p1Prompt = new kalahPromptGetInputCondition();
		while (finalMoveIndex == 6) {
			int[] storeTotalNumberArr = kalahCases.gameFinishRoundOne(io, numberArray);
			if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
				finished = true; // Use to exist the outer for loop
				break; // Use to exist the inner while loop
			}
			char inputChar = p1Prompt.p1Prompt(io);
			if (inputChar == 'q') {
				kalahCases.printGameOverAndBoard(io, kalahBoard, numberArray);
				finished = true;
				break;
			}
			int collectSeedFromHouse = getCollectSeedFromInputChar(inputChar, numberArray[0]);
			returnIntWithIntArr intElementsP1Array = playerOne.playerOneRound(io, numberArray, inputChar);
			numberArray = intElementsP1Array.NumArray;
			finalMoveIndex = intElementsP1Array.finalMoveIndex;
			finished = collectSeedZeroCaseBooleanOne(io, collectSeedFromHouse, inputChar, numberArray);
		}
		return finished;
	}

	public boolean finalMoveAtStoreP2 (IO io, KalahBoard kalahBoard, int finalMoveIndex, int[][] numberArray) {
		boolean finished = false;
		KalahCases kalahCases = new KalahCases();
		Player playerTwo = new Player();
		kalahPromptGetInputCondition p2Prompt = new kalahPromptGetInputCondition();
		while (finalMoveIndex == 6) {
			int[] storeTotalNumberArr = kalahCases.gameFinishRoundTwo(io, numberArray);
			if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
				finished = true; 
				break; 
			}
			char inputChar = p2Prompt.p2Prompt(io);
			if (inputChar == 'q') {
				kalahCases.printGameOverAndBoard(io, kalahBoard, numberArray);
				finished = true;
				break;
			}
			int collectSeedFromHouse = getCollectSeedFromInputChar(inputChar, numberArray[1]);
			returnIntWithIntArr intElementsP2Array = playerTwo.playerTwoRound(io, numberArray, inputChar, false);
			numberArray = intElementsP2Array.NumArray;
			finalMoveIndex = intElementsP2Array.finalMoveIndex;
			finished = collectSeedZeroCaseBooleanTwo(io, collectSeedFromHouse, inputChar, numberArray);
		}
		return finished;
	}

	public boolean regularMoveStepP1 (IO io, KalahBoard kalahBoard, char inputChar, int[][] numberArray) {
		Player playerOne = new Player();
		int collectSeedFromHouse = getCollectSeedFromInputChar(inputChar, numberArray[0]);
		boolean finished = collectSeedZeroCaseBooleanOne(io, collectSeedFromHouse, inputChar, numberArray);
		if (collectSeedFromHouse != 0) {
			returnIntWithIntArr intElementsP1Array = playerOne.playerOneRound(io, numberArray, inputChar);
			numberArray = intElementsP1Array.NumArray;
			int finalMoveIndex = intElementsP1Array.finalMoveIndex;
			if (finalMoveIndex == 6) {
				finished = finalMoveAtStoreP1(io, kalahBoard, finalMoveIndex, numberArray);
			}
		}
		return finished;
	}

	public boolean regularMoveStepP2 (IO io, KalahBoard kalahBoard, char inputChar, int[][] numberArray) {
		Player playerTwo = new Player();
		int collectSeedFromHouse = getCollectSeedFromInputChar(inputChar, numberArray[1]);
		boolean finished = collectSeedZeroCaseBooleanTwo(io, collectSeedFromHouse, inputChar, numberArray);
		if (collectSeedFromHouse != 0) {
			returnIntWithIntArr intElementsP2Array = playerTwo.playerTwoRound(io, numberArray, inputChar, false);
			numberArray = intElementsP2Array.NumArray;
			int finalMoveIndex = intElementsP2Array.finalMoveIndex;
			if (finalMoveIndex == 6) {
				finished = finalMoveAtStoreP2(io, kalahBoard, finalMoveIndex, numberArray);
			}
		}
		return finished;
	}


    public boolean regularMoveStepRobot (IO io, KalahBoard kalahBoard, int[][] numberArray, boolean isExtraMove) {
		System.out.println("address of numberArray: " + numberArray);
		//Player robot = new Player();
		KalahCases kalahCases = new KalahCases();
		boolean finished = false;
        int[][][] combineArray = getCombineArray(io, numberArray);

		if (isExtraMove == true) {
			int[] storeTotalNumberArr = kalahCases.gameFinishRoundTwo(io, numberArray);
			if ((storeTotalNumberArr[0] != 0) && (storeTotalNumberArr[1] != 0) ){
				finished = true;
				return finished;
			}
		}
		/*
		CombineArray (when p1 input 5 after initial): [
		[[4, 4, 4, 4, 0, 5, 1, ][0, 6, 5, 5, 5, 5, 0, ][5, ]]
		[[4, 4, 4, 4, 0, 5, 1, ][5, 0, 5, 5, 5, 5, 1, ][6, ]]
		[[4, 4, 4, 4, 0, 5, 1, ][5, 5, 0, 5, 5, 5, 1, ][6, ]]
		[[5, 4, 4, 4, 0, 5, 1, ][5, 5, 4, 0, 5, 5, 1, ][7, ]]
		[[5, 5, 4, 4, 0, 5, 1, ][5, 5, 4, 4, 0, 5, 1, ][8, ]]
		[[5, 5, 5, 4, 0, 5, 1, ][5, 5, 4, 4, 4, 0, 1, ][9, ]]
		]
		*/
		boolean getOutput = false;
        for (int i=0; i<6; i++) {
            int[][] numberArrayNew = {combineArray[i][0], combineArray[i][1], numberArray[2]};
			int finalIndex = combineArray[i][2][0];
			if (finalIndex < numberArray[1].length) {
				if (finalIndex == 6) {
					io.println("Player P2 (Robot) chooses house #" + (i+1) + " because it leads to an extra move");
					numberArray[0] = numberArrayNew[0];
					numberArray[1] = numberArrayNew[1];
					numberArray[2] = numberArrayNew[2];
					getOutput = true;
					kalahBoard.printKalahBoard(io, numberArray);
					// One more move
					System.out.println("!!!");
					finished = regularMoveStepRobot(io, kalahBoard, numberArray, true);
					
					break;
				}			
			}
        }

		if (getOutput == false) {
			for (int k=0; k<6; k++) {
				int[][] numberArrayNew = {combineArray[k][0], combineArray[k][1], numberArray[2]};
				int finalIndex = combineArray[k][2][0];
				if (finalIndex < numberArray[1].length) {
					if ((combineArray[k][0][combineArray[k][0].length-2-finalIndex] == 0) && (combineArray[k][1][finalIndex] == 0) && (combineArray[k][1][6] > numberArray[1][6]) && ((numberArray[0][numberArray[0].length-2-finalIndex] != 0) || ((numberArray[1][k]%13 > numberArray[1].length) && (numberArray[0][numberArray[0].length-2-finalIndex] == 0) && (combineArray[k][1][6] - numberArray[1][6]-2 == 1)))) {
						io.println("Player P2 (Robot) chooses house #" + (k+1) + " because it leads to a capture");
						numberArray[0] = numberArrayNew[0];
						numberArray[1] = numberArrayNew[1];
						numberArray[2] = numberArrayNew[2];
						getOutput = true;
						kalahBoard.printKalahBoard(io, numberArray);
						break;
					} 
				}
			}
		}

		if (getOutput == false) {
			for (int j=0; j<6; j++) {
				if (numberArray[1][j] != 0) {
					io.println("Player P2 (Robot) chooses house #" + (j+1) + " because it is the first legal move");
					int[][] numberArrayLegal = {combineArray[j][0], combineArray[j][1], numberArray[2]};
					numberArray[0] = numberArrayLegal[0];
					numberArray[1] = numberArrayLegal[1];
					numberArray[2] = numberArrayLegal[2];
					kalahBoard.printKalahBoard(io, numberArray);
					break;
				}
			}				
		}
		return finished;
        
	}

    public int[][][] getCombineArray (IO io, int[][] numberArray) {
        Player robot = new Player();
        int[][][] combineArray = {{},{},{},{},{},{}};
		int[][] temp = clone(numberArray);
		int index=0;
        while (index<6) {
			int[][] UseNumArray = clone(temp);
            char possibleIndexChar = (char)((index+1) + '0');
		    // The last parameter for playerTwoRound is the boolean bmf
			returnIntWithIntArr intElementsP2Array = robot.playerTwoRound(io, UseNumArray, possibleIndexChar, true);
			UseNumArray = intElementsP2Array.NumArray;
			int finalMoveIndex = intElementsP2Array.finalMoveIndex;
			if (temp[1][index] == 0) {
				finalMoveIndex = index;
			}
			int[][] ArrayComponent =  {UseNumArray[0], UseNumArray[1], {finalMoveIndex}};
			combineArray[index] = ArrayComponent;
			index++;
        }
        return combineArray;
    }

	public int[][] clone(int[][] a) {
        int[][] b = new int[a.length][];
        for (int i = 0; i < a.length; i++) {
			b[i] = a[i].clone();
		}
		return b;
    }
}
