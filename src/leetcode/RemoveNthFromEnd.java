package leetcode;

/**
 * Created by evtHoriz on 15/4/23.
 */
public class RemoveNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode fast = sentinel, slow = sentinel;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = new RemoveNthFromEnd().removeNthFromEnd(head, 2);
        ListNode c = result;
        do {
            System.out.print(c.val + "->");
        }while ( (c=c.next)!=null);
    }
}
