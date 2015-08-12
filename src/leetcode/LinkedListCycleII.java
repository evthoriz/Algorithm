package leetcode;

import java.util.HashSet;

/**
 * Created by evtHoriz on 15/8/12.
 * Email: evthoriz@gmail.com
 * <p/>
 * 设到入口的距离：x
 * 设快慢指针在距离入口 m 处相遇
 * 设环长度为：y
 * <p/>
 * 根据相遇时 快指针的路程是慢指针的两倍，得到
 * x+ky+m = 2(x+ty+m)
 * (k-2t)y = x+m
 * 即 x+m 是 y 的倍数
 * 因此他们的相遇点 m，只要再前进 x 步 一定为入口。
 * 所以可以在计算出相遇点之后，让一个指针从头开始前进x步，另一个指针从m处开始走x步，他们就注定在入口相遇。
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) return null;
        ListNode q = head, s = head;

        while (q.next != null && q.next.next != null && s.next != null) {
            q = q.next.next;
            s = s.next;

            if (q == s) {
                s = head;
                while (s != q) {
                    s = s.next;
                    q = q.next;
                }
                return s;
            }

        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        
        if (head == null || head.next == null) return null;
        ListNode q = head;

        HashSet<ListNode> set = new HashSet<ListNode>();
        while (q.next != null) {
            if (set.contains(q)) {
                return q;
            }
            set.add(q);
            q = q.next;
        }
        return null;
    }
}
