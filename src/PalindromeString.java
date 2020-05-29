/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class PalindromeString {
    private static class Solution {
        public boolean isPalindrome(String s) {
            int i = -1;
            int j = s.length();
            if (j < 1) {
                return true;
            }

            char c1;
            char c2;
            while (i < j) {
                do {
                    c1 = s.charAt(++ i);
                    if ((c1 >= '0' && c1 <= '9') || (c1 >= 'a' && c1 <= 'z')) {
                        break;
                    } else if (c1 >= 'A' && c1 <= 'Z') {
                        c1 = (char)(c1 + 32);
                        break;
                    }
                } while (i <= j && i < s.length() - 1);

                do {
                    c2 = s.charAt(-- j);
                    if ((c2 >= '0' && c2 <= '9') || (c2 >= 'a' && c2 <= 'z')) {
                        break;
                    } else if (c2 >= 'A' && c2 <= 'Z') {
                        c2 = (char)(c2 + 32);
                        break;
                    }
                } while (i <= j && j > 0);

                if (i > j) {
                    break;
                }

                if (c1 != c2) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s;

        s = "A man, a plan, a canal: Panama";
        System.out.println(s + ", " + solution.isPalindrome(s));

        s = "race a car";
        System.out.println(s + ", " + solution.isPalindrome(s));

        s = "rar";
        System.out.println(s + ", " + solution.isPalindrome(s));

        s = "";
        System.out.println(s + ", " + solution.isPalindrome(s));

        s = "a";
        System.out.println(s + ", " + solution.isPalindrome(s));

        s = "a ";
        System.out.println(s + ", " + solution.isPalindrome(s));

        s = " a ";
        System.out.println(s + ", " + solution.isPalindrome(s));
    }
}
