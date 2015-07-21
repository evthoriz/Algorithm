package utils;

import leetcode.ListNode;

/**
 * Created by evtHoriz on 15/3/6.
 */
public class Util {

    public static void printArray(int[] Arr) {
        System.out.print("[");
        for (int i=0; i<Arr.length; i++) {
            System.out.print(Arr[i] + ((i==Arr.length-1)?"":","));
        }
        System.out.println("]");
    }

    public static void printNodeList(ListNode head) {
        ListNode l = head;
        do {
            System.out.print(l.val + "->");
        } while ((l = l.next) != null);
        System.out.println("null");
    }

    public static void main(String[] args){
        printArray(new int[]{1,1,2,3,5});
    }
}
