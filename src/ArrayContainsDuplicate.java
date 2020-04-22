import java.util.HashSet;
import java.util.Set;

public class ArrayContainsDuplicate {
    private static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> tmp = new HashSet<>();
            for (int i : nums) {
                if (!tmp.add(i)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(!s.containsDuplicate(new int[]{7,6,4,3,1}));
        System.out.println(!s.containsDuplicate(new int[]{7,1,5,3,6,4}));
        System.out.println(s.containsDuplicate(new int[]{7,2,1,2,5,3,6,4}));
        System.out.println(!s.containsDuplicate(new int[]{1,2,3,4,5}));
    }
}
