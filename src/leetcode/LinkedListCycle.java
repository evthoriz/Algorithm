package leetcode;

/**
 * Created by evtHoriz on 15/8/12.
 * Email: evthoriz@gmail.com
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode q = head, s = head;

        do {
            s = s.next;
            q = q.next.next;
            if (q == s || q.next == s) return true;
        } while (q.next != null && q.next.next != null && s != head);


        return false;
    }

    public static void main(String[] args) {

    }
}
