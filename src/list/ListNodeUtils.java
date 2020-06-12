package list;

/**
 * Definition for singly-linked list.
 */
public class ListNodeUtils {
    static ListNode newList(int[] vals) {
        ListNode head = null;
        if (vals.length > 0) {
            head = new ListNode(vals[0]);
            ListNode tmp = head;
            for (int j = 1; j < vals.length; j ++) {
                tmp.next = new ListNode(vals[j]);
                tmp = tmp.next;
            }
        }

        return head;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
