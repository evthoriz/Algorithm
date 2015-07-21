package leetcode;

import org.w3c.dom.NodeList;
import utils.Util;

/**
 * Created by evtHoriz on 15/5/8.
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int i = 1; i < 10; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }

        ListNode result = new ReverseKGroup().reverse2(dummy.next);
        Util.printNodeList(result);
        ListNode result2 = new ReverseKGroup().reverse2(result);
        Util.printNodeList(result2);

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }

    public ListNode reverse2(ListNode current) {
        ListNode previous = null;
        ListNode next;
        int i = 0;
        while (current != null && i++ < 4) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode reverse(ListNode current) {
        if (current.next == null) {
            return current;
        }
        ListNode nextNode = current.next;
        current.next = null;
        ListNode restNde = reverse(nextNode);
        nextNode.next = current;
        return restNde;
    }


}
