package array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class ArrayRotate {
    private static class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = k % len;

            int idx = 0;
            int tmpIdx = 0;
            int cache = nums[idx];
            for (int count = 0; count < k; count ++) {
                while (idx < len) {
                    int tmp = nums[(idx + k) % len];
                    nums[(idx + k) % len] = cache;
                    cache = tmp;

                    idx += k;
                }

                // If idx back to the original index, move to next
                idx = idx % len;
                if (idx == tmpIdx) {
                    tmpIdx = (++ idx);
                    cache = nums[idx];
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        s.rotate(nums, 3);
        for (int i : nums) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
}
