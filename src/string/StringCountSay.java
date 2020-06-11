package string;

/**
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 */
public class StringCountSay {
    private static class Solution {
        private String countAndSay(int end, int current, String str) {
            if (current > end) {
                return str;
            } else {
                StringBuilder sb = new StringBuilder();
                char orig = str.charAt(0);
                char cur;
                int count = 1;
                int i = 1;
                while (i < str.length()) {
                    if ((cur = str.charAt(i ++)) == orig) {
                        count ++;
                    } else {
                        sb.append(count).append(orig);
                        orig = cur;
                        count = 1;
                    }
                }

                sb.append(count).append(orig);
                return countAndSay(end, current + 1, sb.toString());
            }

        }

        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            } else if (n == 2) {
                return "11";
            } else if (n == 3) {
                return "21";
            } else if (n == 4) {
                return "1211";
            } else {
                return countAndSay(n, 6, "111221");
            }
        }
    }

    public static void test(Solution s, int i, String expect) {
        String actual = s.countAndSay(i);
        System.out.println("[" + i + "][expect:" + expect + "]:" + "[actual:" + actual + "], result: " + (expect.equals(actual)));
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        test(s, 1, "1");
        test(s, 2, "11");
        test(s, 3, "21");
        test(s, 4, "1211");
        test(s, 5, "111221");
        test(s, 6, "312211");
        test(s, 7, "13112221");
    }
}
