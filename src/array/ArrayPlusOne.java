package array;

public class ArrayPlusOne {
    private static class Solution {
        public int[] plusOne(int[] digits) {
            int d = 1;
            int[] ret = new int[digits.length];
            for (int i = digits.length - 1; i >= 0; i --) {
                d = digits[i] + d;
                if (d > 9) {
                    ret[i] = d - 10;
                    d = 1;
                } else {
                    ret[i] = d;
                    d = 0;
                }
            }

            if (d > 0) {
                int[] newRet = new int[digits.length + 1];
                newRet[0] = 1;
                System.arraycopy(ret, 0, newRet, 1, digits.length);
                return newRet;
            } else {
                return ret;
            }
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] digits;
        Solution s = new Solution();

        digits = new int[]{1,2,3};
        printArray(s.plusOne(digits));

        digits = new int[]{4,3,2,1};
        printArray(s.plusOne(digits));

        digits = new int[]{9};
        printArray(s.plusOne(digits));

        digits = new int[]{1, 9};
        printArray(s.plusOne(digits));

        digits = new int[]{9, 9};
        printArray(s.plusOne(digits));

        digits = new int[]{2, 9, 9};
        printArray(s.plusOne(digits));
    }
}
