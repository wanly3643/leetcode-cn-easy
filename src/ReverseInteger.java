public class ReverseInteger {
    private static class Solution {
        public int reverse(int x) {
            long lx = x;
            long ret = 0;
            while (lx != 0) {
                ret = ret * 10 + lx % 10;
                lx = lx / 10;
            }

            if (ret < Integer.MIN_VALUE || ret > Integer.MAX_VALUE) {
                return 0;
            }

            return (int)ret;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int x;

        x = 0;
        System.out.println (x + ":" + (s.reverse(x) == 0));

        x = -1;
        System.out.println (x + ":" + (s.reverse(x) == -1));

        x = 10;
        System.out.println (x + ":" + (s.reverse(x) == 1));

        x = 100;
        System.out.println (x + ":" + (s.reverse(x) == 1));

        x = 101;
        System.out.println (x + ":" + (s.reverse(x) == 101));

        x = -10;
        System.out.println (x + ":" + (s.reverse(x) == -1));

        x = -100;
        System.out.println (x + ":" + (s.reverse(x) == -1));

        x = -101;
        System.out.println (x + ":" + (s.reverse(x) == -101));

        x = 123;
        System.out.println (x + ":" + (s.reverse(x) == 321));

        x = -123;
        System.out.println (x + ":" + (s.reverse(x) == -321));

        x = -2147483648;
        System.out.println (x + ":" + (s.reverse(x) == 0));

        x = 2147483647;
        System.out.println (x + ":" + (s.reverse(x) == 0));

        x = 2147483642;
        System.out.println (x + ":" + (s.reverse(x) == 0));

        x = 2147473412;
        System.out.println (x + ":" + (s.reverse(x) == 2143747412));

        x = -2147473412;
        System.out.println (x + ":" + (s.reverse(x) == -2143747412));
    }
}
