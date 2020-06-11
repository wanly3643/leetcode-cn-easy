/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StringStrstr {
    private static class Solution {
        public int strStr(String haystack, String needle) {
            int nLen = needle.length();
            if (nLen <= 0) {
                return 0;
            }

            int i = 0;
            int j;
            boolean found;
            while (i <= haystack.length() - nLen) {
                j = 0;
                found = true;
                while (j <= nLen - 1 - j) {
                    if (haystack.charAt(i + j) != needle.charAt(j)
                            || haystack.charAt(i + (nLen - 1 - j)) != needle.charAt(nLen - 1 - j)) {
                        found = false;
                        break;
                    }
                    j ++;
                }

                if (found) {
                    return i;
                }

                i ++;
            }

            return -1;
        }
    }

    public static void test(Solution s, String haystack, String needle) {
        int actual = s.strStr(haystack, needle);
        System.out.println("[" + haystack + "][needle:" + needle + "], result: " + (actual));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        test(s, "hello", "ll");
        test(s, "hello", "a");
        test(s, "hello", "");
        test(s, "aaaaa", "ll");
        test(s, "a", "aa");
    }
}
