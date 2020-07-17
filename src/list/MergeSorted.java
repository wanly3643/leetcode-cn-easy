/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
package list;

public class MergeSorted {
    private static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int total = m + n - 1;
            int i = m - 1, j = n - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] < nums2[j]) {
                    nums1[total --] = nums2[j --];
                } else {
                    nums1[total --] = nums1[i --];
                }
            }

            while (j >= 0) {
                nums1[total --] = nums2[j --];
            }
        }
    }

    private static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i);
            System.out.print(" ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1;
        int[] nums2;
        int m, n;

        nums1 = new int[]{4,8,9,0,0,0};
        nums2 = new int[]{0,5,6};
        m = 3;
        n = 3;
        s.merge(nums1, m, nums2, n);
        print(nums1);
    }
}
