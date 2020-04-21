/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */

public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int expect;
            int nums_length = nums.length;
            for (int i = 0; i < nums_length; i ++) {
                expect = target - nums[i];
                for (int j = i + 1; j < nums_length; j ++) {
                    if (expect == nums[j]) {
                        return new int[]{i, j};
                    }
                }
            }

            return new int[]{-1, -1};
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // Test 1
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 18;
        int[] ret = s.twoSum(nums, target);
        System.out.println("[" + ret[0] + ", " + ret[1] + "]");
    }
}
