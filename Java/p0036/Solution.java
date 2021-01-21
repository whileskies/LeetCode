package p0036;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //solution0
    public boolean isValidSudoku0(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            if (!isValidRow(board, r))
                return false;
        }

        for (int c = 0; c < board[0].length; c++) {
            if (!isValidCol(board, c))
                return false;
        }

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!isValidGrid(board, r, c))
                    return false;
            }
        }

        return true;
    }

    private boolean noRepeat(int[] digit) {
        for (int i = 0; i < 10; i++) {
            if (digit[i] > 1)
                return false;
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        int[] digit = new int[10];

        for (int c = 0; c < board[row].length; c++) {
            if (board[row][c] != '.') {
                digit[board[row][c] - '0'] ++;
            }
        }
        return noRepeat(digit);
    }

    private boolean isValidCol(char[][] board, int col) {
        int[] digit = new int[10];

        for (int r = 0; r < board.length; r++) {
            if (board[r][col] != '.') {
                digit[board[r][col] - '0'] ++;
            }
        }

        return noRepeat(digit);
    }

    private boolean isValidGrid(char[][] board, int rNum, int cNum) {
        int[] digit = new int[10];

        int rUp = 3 * rNum, rDown = rUp + 2;
        int cLeft = 3 * cNum, cRight = cLeft + 2;

        for (int r = rUp; r <= rDown; r++) {
            for (int c = cLeft; c <= cRight; c++) {
                if (board[r][c] != '.') {
                    digit[board[r][c] - '0'] ++;
                }
            }
        }

        return noRepeat(digit);
    }


    //solution 1
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Boolean>[] rowMaps = new HashMap[9];
        HashMap<Character, Boolean>[] colMaps = new HashMap[9];
        HashMap<Character, Boolean>[] boxMaps = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rowMaps[i] = new HashMap<>();
            colMaps[i] = new HashMap<>();
            boxMaps[i] = new HashMap<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    char key = board[r][c];
                    if (rowMaps[r].containsKey(key))
                        return false;
                    rowMaps[r].put(key, true);
                    if (colMaps[c].containsKey(key))
                        return false;
                    colMaps[c].put(key, true);
                    int boxIndex = (r / 3) * 3 + (c / 3);
                    if (boxMaps[boxIndex].containsKey(key))
                        return false;
                    boxMaps[boxIndex].put(key, true);
                }
            }
        }

        return true;
    }


}
