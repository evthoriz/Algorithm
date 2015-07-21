package leetcode;

import java.util.HashSet;

/**
 * Created by evtHoriz on 15/7/20.
 * Email: evthoriz@gmail.com
 * tips 每一行所有数字都只能出现一次，每一列所有数字都只能出现一次。
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> setRow = new HashSet<Character>();
            HashSet<Character> setCol = new HashSet<Character>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.') {
                    if (setRow.contains(board[i][j])) {
                        return false;
                    } else {
                        setRow.add(board[i][j]);
                    }
                }
                if (board[j][i]!='.') {
                    if (setCol.contains(board[j][i])) {
                        return false;
                    } else {
                        setCol.add(board[j][i]);
                    }
                }
            }
        }

        for (int block = 0; block < 9; block ++) {
            HashSet<Character> set9 = new HashSet<Character>();
            for (int i = 0 + 3 *(block / 3); i < 3 +  3*(block / 3); i++) {
                for (int j = 0 + 3 * (block % 3); j < 3 +  3 * (block % 3); j++) {
                    if (board[i][j] != '.') {
                        if (set9.contains(board[i][j])) return false;
                        else set9.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[10][10];
        new ValidSudoku().isValidSudoku(board);
    }
}
