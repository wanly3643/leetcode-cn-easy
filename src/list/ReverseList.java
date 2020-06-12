package list;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {
    private static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode next = head;
            ListNode cur = null;
            ListNode tmp;
            while (next != null) {
                tmp = next;
                next = next.next;
                tmp.next = cur;
                cur = tmp;
            }

            return cur;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head;

        head = ListNodeUtils.newList(new int[]{1, 2, 3, 4, 5});
        head = s.reverseList(head);
        ListNodeUtils.printList(head);

        head = s.reverseList(head);
        ListNodeUtils.printList(head);

        head = ListNodeUtils.newList(new int[]{1});
        head = s.reverseList(head);
        ListNodeUtils.printList(head);

        head = s.reverseList(head);
        ListNodeUtils.printList(head);

        head = ListNodeUtils.newList(new int[]{1, 2});
        head = s.reverseList(head);
        ListNodeUtils.printList(head);

        head = s.reverseList(head);
        ListNodeUtils.printList(head);
    }
}
