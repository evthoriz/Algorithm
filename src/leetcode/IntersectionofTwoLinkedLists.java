package leetcode;

import java.util.HashSet;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 * tips: 求汇聚点，可以用hashset保存一条list的node，空间O(m),时间O(1),
 * 可以使用双指针，遍历两遍。想法是，让两者第二次遍历时可以距离汇聚点一样远。
 * 也可以直接算出两条list的长度，然后让长的先走，直到和短的距离汇聚点一样远。
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node = headA;
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (node != null) {
            set.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        for (int i = 0; i<3; i++) {
            while (nodeA != null && nodeB != null) {
                if (nodeA.equals(nodeB)) return nodeA;

                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }

            if (nodeA == null) {
                nodeA = headB;
            }

            if (nodeB == null) {
                nodeB = headA;
            }
        }

        return null;
    }
}
