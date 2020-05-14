import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class ArrayIntersect {
    private static class Solution {
        private static class Count {
            private int c = 0;
            public int inc() {
                this.c = this.c + 1;
                return this.c;
            }

            public int dec() {
                this.c = this.c - 1;
                return this.c;
            }

            public int val() {
                return this.c;
            }
        }
        private Map<Integer, Count> numsCount(int[] nums) {
            Map<Integer, Count> cache = new HashMap<>();
            for (int i : nums) {
                Count c = cache.get(i);
                if (c == null) {
                    c = new Count();
                    cache.put(i, c);
                }

                c.inc();
            }

            return cache;
        }

        public int[] intersect(int[] nums1, int[] nums2) {
            int[] min;
            Map<Integer, Count> max;
            if (nums1.length > nums2.length) {
                max = numsCount(nums1);
                min = nums2;
            } else {
                max = numsCount(nums2);
                min = nums1;
            }

            List<Integer> ret1 = new LinkedList<>();
            for (int m: min) {
                Integer i = new Integer(m);
                Count c = max.get(i);
                if (c != null) {
                    c.dec();
                    ret1.add(i);

                    if (c.val() == 0) {
                        max.remove(i);
                    }
                }
            }

            int[] ret = new int[ret1.size()];
            int i = 0;
            for (Integer val : ret1) {
                ret[i ++] = val;
            }

            return ret;
        }

    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1;
        int[] nums2;

        Solution s = new Solution();

        nums1 = new int[]{1,2,2,1};
        nums2 = new int[]{2,2};
        printArray(s.intersect(nums1, nums2));

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};
        printArray(s.intersect(nums1, nums2));
    }
}
