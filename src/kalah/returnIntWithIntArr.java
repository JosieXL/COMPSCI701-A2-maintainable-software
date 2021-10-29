package kalah;

/**
 * This class is the returnIntWithIntArr class.  
 * Here are two constructors either return an 
 * integer and a 1d int array, or an integer and
 * a 2d int array.
 * @param numberArray is {p1NumberArray, p2NumberArray, {vertical}}
 */

public class returnIntWithIntArr {
    int finalMoveIndex;
    int[][] NumArray;
    int[] numArrayOneD;
    
    public returnIntWithIntArr(int finalMoveNum, int[][] NumberArray) {
        finalMoveIndex = finalMoveNum;
        NumArray = NumberArray;
    }

    public returnIntWithIntArr(int finalMoveNum, int[] numArray1D) {
        finalMoveIndex = finalMoveNum;
        numArrayOneD = numArray1D;
    }
}