package leetcode;

/**
 * Created by evtHoriz on 15/4/23.
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        if (l1 != null) {
            l.next = l1;
        }
        if (l2 != null) {
            l.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);

        ListNode l = new MergeTwoLists().mergeTwoLists(l1, l2);
        do {
            System.out.print(l.val + "->");
        } while ((l = l.next) != null);
    }
}
