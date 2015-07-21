package leetcode;

import utils.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/7/15.
 * Email: evthoriz@gmail.com
 * head->1->2->3->4->5->null
 * head->5->4->3->2->1->null
 * <p/>
 * tips: 迭代法：顺序倒置当前节点和前一个节点，为了可以继续下去，需要同时保持对后一个节点的引用。一直迭代直到后续没有节点。
 * 递归法：交换当前节点和前一个节点，如果当前节点不是最后一个节点的话，当前节点的下一个节点和当前节点交换。（这个想法不正确）。
 * 正确的想法是倒置当前节点和前一个节点，如果后需还有节点的话，重复该操作。这个想法和迭代法是一模一样的，还是从前往后倒置的。
 * 但它并没有一个变量来动态保存对后一个节点的引用，用一个局部变量，直接传入下次递归中。
 *
 * 递归的使用场景至少又两种：
 * 1. 当前解需要依据上个解，如 fibonnci 队列，用递推式，递推至baseline为止逐层返回结果不断供上一层调用者使用。
 * 2. 后续操作和前面操作一样。重复逻辑可以用一个递归代替。
 */
public class ReverseLinkedList {


    public ListNode reverseList3(ListNode first) {
        if (first == null) {
            return null;
        }


        ListNode second = first.next;
        first.next = null;

        return reverse(first, second);

    }

    /**
     * reserve(0,1);
     * 0,1
     * 1,2
     * 1->0
     * reserve(1,2)
     * 1,2
     * 2,3
     * 2->1
     *
     * reverse(4,5)
     * 4,5
     * 5,null
     * 5->4
     *
     *
     * reverse(5,null)
     * 5,null
     * return;
     *
     *
     *
     * @param prev
     * @param cur
     */

    public ListNode reverse(ListNode prev, ListNode cur) {

        if (cur == null) {
            return prev;
        }

        ListNode curr = cur.next;
        cur.next = prev;
        return reverse(cur, curr);

    }


    public ListNode reverseList2(ListNode first) {

        if (first == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = first;
        ListNode next = first.next;

        do {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        } while (next != null);

        cur.next = prev;
        return cur;
    }


    public ListNode reverseList(ListNode first) {

        ListNode head = new ListNode(-1);
        head.next = first;

        if (first == null) {
            return null;
        }
        List<ListNode> nodeList = new ArrayList<ListNode>();


        ListNode node = first;

        while (node != null) {
            nodeList.add(node);
            node = node.next;
        }

        int size = nodeList.size();
        int i = size;
        while (i > 1) {
            nodeList.get(i - 1).next = nodeList.get(i - 1 - 1);
            i--;
        }

        nodeList.get(0).next = null;
        head.next = nodeList.get(size - 1);
        return head;
    }


    public static void main(String[] args) {
        ListNode first = new ListNode(0);

        first.next = new ListNode(1);
        first.next.next = new ListNode(2);
        first.next.next.next = new ListNode(3);
        first.next.next.next.next = new ListNode(4);
        first.next.next.next.next.next = new ListNode(5);

        Util.printNodeList(new ReverseLinkedList().reverseList3(first));

    }

}
