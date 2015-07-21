package leetcode;

/**
 * Created by evtHoriz on 15/7/14.
 * Email: evthoriz@gmail.com
 *
 * tips: 迭代时，不同时，才跳到下一个。
 */
public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.next.val == node.val) {
                node.next = node.next.next;

            } else {
                node = node.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(5);

        ListNode result = new RemoveDuplicatesfromSortedList().deleteDuplicates(head);
        ListNode c = result;
        do {
            System.out.print(c.val + "->");
        } while ((c = c.next) != null);
    }
}
