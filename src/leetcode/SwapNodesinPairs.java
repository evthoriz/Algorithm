package leetcode;

import static utils.Util.printNodeList;

/**
 * Created by evtHoriz on 15/5/7.
 */
public class SwapNodesinPairs {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int i = 1; i < 10; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        ListNode result = new SwapNodesinPairs().swapPairs(dummy.next);
        printNodeList(result);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;

        while (last.next != null && last.next.next != null) {
            ListNode p1 = last.next;
            ListNode p2 = p1.next;
            last.next = p2;

            p1.next = p2.next;
            p2.next = p1;
            last = p1;
        }

        return dummy.next;
    }
}
