package array;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class TwoSum2Sorted {
    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int i = 0;
            int j = nums.length - 1;
            int expect;
            while (i < j) {
                expect = target - nums[i];
                if (expect > nums[j]) {
                    i ++;
                } else if (expect < nums[j]) {
                    j --;
                } else {
                    return new int[]{i + 1, j + 1};
                }
            }

            return new int[]{0, 0};
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // Test 1
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] ret = s.twoSum(nums, target);
        System.out.println("[" + ret[0] + ", " + ret[1] + "]");
    }
}
