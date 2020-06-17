package list;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeList {
    private static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode first = head;
            ListNode last;
            ListNode tmp;
            while (first != null) {
                tmp = first;
                last = head;
                while(tmp.next != null) {
                    last = last.next;
                    tmp = tmp.next;
                }

                if (last.val != first.val) {
                    return false;
                }

                // move
                first = first.next;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head;

        head = ListNodeUtils.newList(new int[]{1});
        ListNodeUtils.printList(head);
        System.out.println(s.isPalindrome(head));

        head = ListNodeUtils.newList(new int[]{1, 2});
        ListNodeUtils.printList(head);
        System.out.println(s.isPalindrome(head));

        head = ListNodeUtils.newList(new int[]{1, 2, 1});
        ListNodeUtils.printList(head);
        System.out.println(s.isPalindrome(head));

        head = ListNodeUtils.newList(new int[]{1, 2, 2, 1});
        ListNodeUtils.printList(head);
        System.out.println(s.isPalindrome(head));

        head = ListNodeUtils.newList(new int[]{1, 2, 2, 1, 2});
        ListNodeUtils.printList(head);
        System.out.println(s.isPalindrome(head));
    }
}
