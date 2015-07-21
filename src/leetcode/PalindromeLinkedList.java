package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by evtHoriz on 15/7/16.
 * Email: evthoriz@gmail.com
 *
 * O(n) time and O(n) space
 *
 * 如果需要 O(1) space, 通过快慢双指针，将前半部分原地倒置。和后半部分比较。
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;
        ListNode node = head;
        List<Integer> l = new ArrayList<Integer>();
        while (node != null) {
            l.add(node.val);
            node = node.next;
        }

        int last = l.size()-1;

        for (int i = 0; i <= last; i++, last--) {
            System.out.println("l["+i+"] = " + l.get(i) + ", last["+last+"]="+l.get(last));
            if (l.get(i).intValue() != l.get(last).intValue()) {

                System.out.println("l["+i+"] = " + l.get(i) + ", last["+last+"]="+l.get(last));
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(-16557==-16557);

        int[] arr = new int[]{-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,-10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557};
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 0; i<20; i++) {

            node.next = new ListNode(arr[i]);
            node = node.next;
        }

        System.out.println(new PalindromeLinkedList().isPalindrome(head.next));
    }
}
