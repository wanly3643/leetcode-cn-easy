package array;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class ArrayTwoSum {
    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> cache = new HashMap<>();
            for (int i = 0; i < nums.length; i ++) {
                cache.computeIfAbsent(nums[i], k -> new LinkedList<>()).add(i);
            }

            for (int i = 0; i < nums.length; i ++) {
                int expect = target - nums[i];
                List<Integer> list = cache.get(expect);
                if (list != null) {
                    for (int found : list) {
                        if (found != i) {
                            return new int[] {i, found};
                        }
                    }
                }
            }

            return new int[]{-1, -1};
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums;
        int target;
        Solution s = new Solution();

        nums = new int[]{2, 7, 11, 15};
        target = 9;
        printArray(s.twoSum(nums, target));

        nums = new int[]{3, 4, 2, 15};
        target = 6;
        printArray(s.twoSum(nums, target));

        nums = new int[]{3, 3};
        target = 6;
        printArray(s.twoSum(nums, target));
    }
}
