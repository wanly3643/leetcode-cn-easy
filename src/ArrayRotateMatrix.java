/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class ArrayRotateMatrix {
    private static class Solution {
        public void rotate(int[][] matrix) {
            int half = matrix.length / 2;
            for (int j = 0; j < half; j ++) {
                int end = matrix.length - j - 1;
                for (int a = 0; a < end - j; a ++) {
                    int tmp = matrix[j][j + a];
                    matrix[j][j + a] = matrix[end - a][j];
                    matrix[end - a][j] = matrix[end][end - a];
                    matrix[end][end - a] = matrix[j + a][end];
                    matrix[j + a][end] = tmp;
                }
            }
        }
    }

    private static void printArray(int[][] array) {
        for (int[] ints : array) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] array;
        array = new int[][] {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };

        s.rotate(array);
        printArray(array);
//        array = new int[][] {
//            {1,2,3},
//            {4,5,6},
//            {7,8,9}
//        };
//
//        s.rotate(array);
//        printArray(array);
    }
}
