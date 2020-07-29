/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
package dynamic;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    private static class Solution {
        public int climbStairs(int n) {
            Map<Integer, Integer> cache = new HashMap<>();
            cache.put(1, 1);
            cache.put(2, 2);
            cache.put(3, 3);
            return climbStairs(1, n, cache) + climbStairs(2, n, cache);
        }

        private int climbStairs(int cur, int n, Map<Integer, Integer> cache) {
            int left = n - cur;
            if (left == 0) {
                return 1;
            } else if (left > 0) {
                Integer cached = cache.get(left);
                if (cached == null) {
                    cached = climbStairs(cur + 1, n, cache) + climbStairs(cur + 2, n, cache);
                    cache.put(left, cached);
                }
                return cached;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.climbStairs(2));
        System.out.println(s.climbStairs(44));
    }
}
