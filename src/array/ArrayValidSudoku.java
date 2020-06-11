package array;

import java.util.Arrays;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class ArrayValidSudoku {
    private static class Solution {
        private static boolean checkValid(char val, boolean[] digits) {
            if (val == '.') {
                return false;
            }
            int idx = (val - '1');
            if (digits[idx]) {
                return true;
            } else {
                digits[idx] = true;
                return false;
            }
        }
        public boolean isValidSudoku(char[][] board) {
            boolean[] digits = new boolean[9];

            // Check columns
            for (int i = 0; i < 9; i ++) {
                Arrays.fill(digits, false);
                for (int j = 0; j < 9; j ++) {
                    if (checkValid(board[j][i], digits)) {
                        return false;
                    }
                }
            }

            // Check rows
            for (int i = 0; i < 9; i ++) {
                Arrays.fill(digits, false);
                for (int j = 0; j < 9; j ++) {
                    if (checkValid(board[i][j], digits)) {
                        return false;
                    }
                }
            }

            // Check 3x3
            for (int i = 0; i < 3; i ++) {
                Arrays.fill(digits, false);
                for (int j = 0; j < 3; j ++) {
                    Arrays.fill(digits, false);
                    for (int a = 0; a < 3; a ++) {
                        for (int b = 0; b < 3; b ++) {
                            if (checkValid(board[i * 3 + a][j * 3 + b], digits)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board;
        board = new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(s.isValidSudoku(board));

        board = new char[][] {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(s.isValidSudoku(board));
    }
}
