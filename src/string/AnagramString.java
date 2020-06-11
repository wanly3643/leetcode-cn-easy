package string;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class AnagramString {
    private static class Solution {
        private void ana(String s, int[] chars) {
            for (char c: s.toCharArray()) {
                int idx = c - 'a';
                chars[idx] = chars[idx] + 1;
            }
        }

        private boolean cmp(int[] s, int[] t) {
            for(int i = 0; i < s.length; i ++) {
                if (s[i] != t[i]) {
                    return false;
                }
            }

            return true;
        }
        public boolean isAnagram(String s, String t) {
            int[] c1 = new int[26];
            Arrays.fill(c1, 0);
            int[] c2 = new int[26];
            Arrays.fill(c2, 0);

            ana(s, c1);
            ana(t, c2);
            return cmp(c1, c2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s;
        String t;

        s = "anagram";
        t = "nagaram";
        System.out.println(s + " / " + t + ", " + solution.isAnagram(s, t));

        s = "rat";
        t = "car";
        System.out.println(s + " / " + t + ", " + solution.isAnagram(s, t));
    }
}
