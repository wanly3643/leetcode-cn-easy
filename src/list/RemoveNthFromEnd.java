package list;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    private static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode tmp = new ListNode(0);
            tmp.next = head;

            ListNode tail = tmp;
            int i = 0;
            while (tail != null && i < n) {
                tail = tail.next;
                i ++;
            }

            if (i >= n && tail != null) {
                ListNode pre = tmp;
                while (tail.next != null) {
                    tail = tail.next;
                    pre = pre.next;
                }
                ListNode deleted = pre.next;
                if (deleted != null) {
                    pre.next = deleted.next;
                    deleted.next = null;
                }
            }

            return tmp.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head;

        head = ListNodeUtils.newList(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.printList(s.removeNthFromEnd(head, 2));

        head = ListNodeUtils.newList(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.printList(s.removeNthFromEnd(head, 5));
    }
}
