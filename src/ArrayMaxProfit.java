public class ArrayMaxProfit {
    private static class Solution {
        public int maxProfit(int[] prices) {
            int max = 0;
            int p;
            for (int i = 0; i < prices.length - 1; i ++) {
                p = prices[i + 1] - prices[i];
                if (p > 0) {
                    max += p;
                }
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}) == 0);
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}) == 7);
        System.out.println(s.maxProfit(new int[]{7,2,1,2,5,3,6,4}) == 7);
        System.out.println(s.maxProfit(new int[]{1,2,3,4,5}) == 4);
    }
}
