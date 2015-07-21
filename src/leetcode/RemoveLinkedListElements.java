package leetcode;

import java.util.List;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;


        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode node = sentinel;

        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return sentinel.next;
    }
}
