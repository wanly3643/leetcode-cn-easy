package list;

public class HasCycle {
    private static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode twoStep = head.next;
            while(twoStep != null && head!= null) {
                if (twoStep == head) {
                    return true;
                }
                head = head.next;
                twoStep = twoStep.next;
                if (twoStep != null) {
                    twoStep = twoStep.next;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head;

        head = ListNodeUtils.newList(new int[]{1});
        System.out.println(!s.hasCycle(head));

        head = ListNodeUtils.newList(new int[]{1});
        head.next = head;
        System.out.println(s.hasCycle(head));

        head = ListNodeUtils.newList(new int[]{1, 2});
        System.out.println(!s.hasCycle(head));

        head = ListNodeUtils.newList(new int[]{1, 2});
        head.next.next = head;
        System.out.println(s.hasCycle(head));

        head = ListNodeUtils.newList(new int[]{1, 2, 3, 4, 5});
        head.next.next.next = head.next;
        System.out.println(s.hasCycle(head));

        head = ListNodeUtils.newList(new int[]{1, 2, 3, 4, 5});
        head.next.next = head.next;
        System.out.println(s.hasCycle(head));

        head = ListNodeUtils.newList(new int[]{1, 2, 3, 4, 5});
        head.next.next.next.next = head.next;
        System.out.println(s.hasCycle(head));
    }
}
