package string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class StringLongestCommonPrefix {
    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length < 1) {
                return "";
            }
            int minLen = strs[0].length();
            for (String s : strs) {
                if (minLen > s.length()) {
                    minLen = s.length();
                }
            }

            int i = 0;
            char c;
            StringBuilder sb = new StringBuilder();
            while(i < minLen) {
                c = strs[0].charAt(i);
                for(int j = 1; j < strs.length; j ++) {
                    if (strs[j].charAt(i) != c) {
                        return sb.toString();
                    }
                }
                sb.append(c);
                i ++;
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs;

        strs = new String[]{"flower","flow","flight"};
        System.out.println(s.longestCommonPrefix(strs));

        strs = new String[]{"dog","racecar","car"};
        System.out.println(s.longestCommonPrefix(strs));

        strs = new String[]{"","racecar","car"};
        System.out.println(s.longestCommonPrefix(strs));

        strs = new String[]{"r","racecar","rar"};
        System.out.println("[" + s.longestCommonPrefix(strs) + "]");
    }
}
