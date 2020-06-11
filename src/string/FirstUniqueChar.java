package string;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */

public class FirstUniqueChar {
    private static class Solution {
        public int firstUniqChar(String s) {
            int[] charIdx = new int[26];
            int max = s.length();
            for(int i = 0; i < 26; i ++) {
                charIdx[i] = max;
            }

            int i = 0;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (charIdx[idx] == max) {
                    charIdx[idx] = i;
                } else {
                    charIdx[idx] = max + 1;
                }

                i ++;
            }

            int ret = max;
            for (int idx : charIdx) {
                if (idx < ret) {
                    ret = idx;
                }
            }

            if (ret == max) {
                return -1;
            } else {
                return ret;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str;
        int expect;

        str = "leetcode";
        expect = 0;
        System.out.println(str + ": " + (s.firstUniqChar(str) == expect));

        str = "loveleetcode";
        expect = 2;
        System.out.println(str + ": " + (s.firstUniqChar(str) == expect));

        str = "aadadaad";
        expect = -1;
        System.out.println(str + ": " + (s.firstUniqChar(str) == expect));
    }
}
