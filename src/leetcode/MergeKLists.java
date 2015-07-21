package leetcode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by evtHoriz on 15/5/7.
 */
public class MergeKLists {


    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });

        for (ListNode n : lists) {
            if (n != null) {
                queue.add(n);
            }
        }

        ListNode sentinel = new ListNode(0);
        ListNode tail = sentinel;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return sentinel.next;
    }
}
