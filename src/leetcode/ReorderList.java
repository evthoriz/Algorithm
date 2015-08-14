package leetcode;

/**
 * Created by evtHoriz on 15/8/14.
 * Email: evthoriz@gmail.com
 * 1 2 3 4 5
 * 1 5 2 4 3
 * <p/>
 * 1 2 3 4 5 6
 * 1 6 2 5 3 4
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        ListNode s = head, q = head;
        ListNode tail = s;

        while (q != null) {
            tail = s;
            s = s.next;
            q = q.next;
            if (q != null) {
                q = q.next;
            }
        }
        tail.next = null;
        ListNode l1 = head;
        ListNode l2 = s;

        // reverse l2 => rl2
        // 1 2 3 4 5 6
        // 反转单链表
        ListNode pre = null;
        ListNode cur = l2;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode rl2 = pre;

        // merge l1 & rl2

        while (l1 != null && rl2 != null) {
            ListNode l1next = l1.next;
            ListNode l2next = rl2.next;

            l1.next = rl2;
            rl2.next = l1next;
            l1 = l1next;
            rl2 = l2next;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        new ReorderList().reorderList(head);
        System.out.println(head);
    }
}
