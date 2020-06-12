package list;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeLists {
    private static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode tmp = head;

            ListNode l1tmp = l1;
            ListNode l2tmp = l2;

            while(l1tmp != null && l2tmp != null) {
                if (l1tmp.val < l2tmp.val) {
                    tmp.next = l1tmp;
                    tmp = l1tmp;
                    l1tmp = l1tmp.next;
                } else {
                    tmp.next = l2tmp;
                    tmp = l2tmp;
                    l2tmp = l2tmp.next;
                }
            }

            if (l1tmp != null) {
                while(l1tmp != null) {
                    tmp.next = l1tmp;
                    tmp = l1tmp;
                    l1tmp = l1tmp.next;
                }
            } else if (l2tmp != null) {
                while(l2tmp != null) {
                    tmp.next = l2tmp;
                    tmp = l2tmp;
                    l2tmp = l2tmp.next;
                }
            }

            return head.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1;
        ListNode l2;

        l1 = ListNodeUtils.newList(new int[]{1});
        l2 = ListNodeUtils.newList(new int[]{2});
        ListNodeUtils.printList(s.mergeTwoLists(l1, l2));

        l1 = ListNodeUtils.newList(new int[]{2});
        l2 = ListNodeUtils.newList(new int[]{1, 3});
        ListNodeUtils.printList(s.mergeTwoLists(l1, l2));

        l1 = ListNodeUtils.newList(new int[]{1, 2});
        l2 = ListNodeUtils.newList(new int[]{3});
        ListNodeUtils.printList(s.mergeTwoLists(l1, l2));

        l1 = ListNodeUtils.newList(new int[]{1, 2, 4});
        l2 = ListNodeUtils.newList(new int[]{3, 5});
        ListNodeUtils.printList(s.mergeTwoLists(l1, l2));
    }
}
