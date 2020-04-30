import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    private static class Solution {
        // 异或的解法非常tricky的
        public int singleNumber(int[] nums) {
            Set<Integer> cache = new HashSet<>();
            for (int n : nums) {
                Integer i = n;
                if (!cache.remove(i)) {
                    cache.add(i);
                }
            }

            Integer[] singles = new Integer[1];
            return cache.toArray(singles)[0];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {2,2,1};
        System.out.println(s.singleNumber(nums) == 1);

        nums = new int[] {4,1,2,1,2};
        System.out.println(s.singleNumber(nums) == 4);
    }
}
