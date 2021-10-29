package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * This class is the KalahBoard class, can print the horizontal board and vertical board.  
 * It contains an override toString() method.
 * @param numberArray is {p1NumberArray, p2NumberArray, {vertical}}
 */

public class KalahBoard {
    public void printKalahBoard(IO io, int[][] numberArray) {
        if (numberArray[2][0] == 1) {
            printKalahBoardVertical(io, numberArray);
        }
        else if (numberArray[2][0] == 0) {
            printKalahBoardHorizontal(io, numberArray);
        }
    }

    // Use to print horizontal Kalah board
    public void printKalahBoardHorizontal(IO io, int[][] numberArray) {
        String[][] kalahBoard = createKalahBoard(numberArray);
        printBoard(io, kalahBoard);
    }

    // Use to print vertical Kalah board
    public void printKalahBoardVertical(IO io, int[][] numberArray) {
        String[][] kalahBoard = createKalahBoardVertical(numberArray);
        printBoard(io, kalahBoard);
    }

    public void printBoard(IO io, String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                io.print(board[i][j] + "");
            }
            io.println("");
        }
    }

    private static String toString(int num) {
        if (num >= 0 && num < 10) {
            return " " + num;
        }
        else {
            return Integer.toString(num);
        }
    }

    public String[] kalahBoardZeroOrLastLine() {
        String[] kalahBoardZeroOrLastLine = {"+----+-------+-------+-------+-------+-------+-------+----+"};
        return kalahBoardZeroOrLastLine;
    }

    public String[] kalahBoardOneLine(int[][] numberArray) {
        String[] kalahBoardOneLine = {"| P2 | 6[" + toString(numberArray[1][5]) + "] | 5[" + toString(numberArray[1][4]) + "] | 4[" + toString(numberArray[1][3]) + "] | 3[" + toString(numberArray[1][2]) + "] | 2[" + toString(numberArray[1][1]) + "] | 1[" + toString(numberArray[1][0]) + "] | " + toString(numberArray[0][6]) + " |"};
        return kalahBoardOneLine;
    }

    public String[] kalahBoardTwoLine() {
        String[] kalahBoardTwoLine = {"|    |-------+-------+-------+-------+-------+-------|    |"};
        return kalahBoardTwoLine;
    }

    public String[] kalahBoardThreeLine(int[][] numberArray) {
        String[] kalahBoardThreeLine = {"| " + toString(numberArray[1][6]) + " | 1[" + toString(numberArray[0][0]) + "] | 2[" + toString(numberArray[0][1]) + "] | 3[" + toString(numberArray[0][2]) + "] | 4[" + toString(numberArray[0][3]) + "] | 5[" + toString(numberArray[0][4]) + "] | 6[" + toString(numberArray[0][5]) + "] | P1 |"};
        return kalahBoardThreeLine;
    }

    public String[] kalahBoardZeroOrLastLineVertical() {
        String[] kalahBoardZeroOrLastLine = {"+---------------+"};
        return kalahBoardZeroOrLastLine;
    }
    
    public String[] kalahBoardOneLineVertical(int[][] numberArray) {
        String[] kalahBoardOneLine = {"|       | P2 " + toString(numberArray[1][6]) + " |"};
        return kalahBoardOneLine;
    }

    public String[] kalahBoardTenLineVertical(int[][] numberArray) {
        String[] kalahBoardTenLine = {"| P1 " + toString(numberArray[0][6]) + " |       |"};
        return kalahBoardTenLine;
    }

    public String[] kalahBoardTwoOrNineLineVertical() {
        String[] kalahBoardTwoLine = {"+-------+-------+"};
        return kalahBoardTwoLine;
    }

    public String[] kalahBoardThreeLineVertical(int[][] numberArray) {
        String[] kalahBoardThreeLine = {"| 1[" + toString(numberArray[0][0]) +  "] | 6[" +  toString(numberArray[1][5]) + "] |"};
        return kalahBoardThreeLine;
    }

    public String[] kalahBoardFourLineVertical(int[][] numberArray) {
        String[] kalahBoardFourLine = {"| 2[" + toString(numberArray[0][1]) +  "] | 5[" +  toString(numberArray[1][4]) + "] |"};
        return kalahBoardFourLine;
    }

    public String[] kalahBoardFiveLineVertical(int[][] numberArray) {
        String[] kalahBoardFiveLine = {"| 3[" + toString(numberArray[0][2]) +  "] | 4[" +  toString(numberArray[1][3]) + "] |"};
        return kalahBoardFiveLine;
    }

    public String[] kalahBoardSixLineVertical(int[][] numberArray) {
        String[] kalahBoardSixLine = {"| 4[" + toString(numberArray[0][3]) +  "] | 3[" +  toString(numberArray[1][2]) + "] |"};
        return kalahBoardSixLine;
    }

    public String[] kalahBoardSevenLineVertical(int[][] numberArray) {
        String[] kalahBoardSevenLine = {"| 5[" + toString(numberArray[0][4]) +  "] | 2[" +  toString(numberArray[1][1]) + "] |"};
        return kalahBoardSevenLine;
    }

    public String[] kalahBoardEightLineVertical(int[][] numberArray) {
        String[] kalahBoardEightLine = {"| 6[" + toString(numberArray[0][5]) +  "] | 1[" +  toString(numberArray[1][0]) + "] |"};
        return kalahBoardEightLine;
    }

    public String[][] createKalahBoard(int[][] numberArray) {
        String[][] kalahBoard = new String[5][60];
        kalahBoard[0] = kalahBoardZeroOrLastLine();
        kalahBoard[1] = kalahBoardOneLine(numberArray);
        kalahBoard[2] = kalahBoardTwoLine();
        kalahBoard[3] = kalahBoardThreeLine(numberArray);
        kalahBoard[4] = kalahBoardZeroOrLastLine();
        return kalahBoard;
    }

    public String[][] createKalahBoardVertical(int[][] numberArray) {
        String[][] kalahBoardVertical = new String[12][17];
        kalahBoardVertical[0] = kalahBoardZeroOrLastLineVertical();
        kalahBoardVertical[1] = kalahBoardOneLineVertical(numberArray);
        kalahBoardVertical[2] = kalahBoardTwoOrNineLineVertical();
        kalahBoardVertical[3] = kalahBoardThreeLineVertical(numberArray);
        kalahBoardVertical[4] = kalahBoardFourLineVertical(numberArray);
        kalahBoardVertical[5] = kalahBoardFiveLineVertical(numberArray);
        kalahBoardVertical[6] = kalahBoardSixLineVertical(numberArray);
        kalahBoardVertical[7] = kalahBoardSevenLineVertical(numberArray);
        kalahBoardVertical[8] = kalahBoardEightLineVertical(numberArray);
        kalahBoardVertical[9] = kalahBoardTwoOrNineLineVertical();
        kalahBoardVertical[10] = kalahBoardTenLineVertical(numberArray);
        kalahBoardVertical[11] = kalahBoardZeroOrLastLineVertical();
        return kalahBoardVertical;
    }
}

