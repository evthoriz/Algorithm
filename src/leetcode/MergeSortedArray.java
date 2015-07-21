package leetcode;

import utils.Util;

/**
 * Created by evtHoriz on 15/7/20.
 * Email: evthoriz@gmail.com
 * tips: 将nums2合并到nums1中，对于每一个num2在nums1中找到自己的位置，即大于nums1的第k个，小于nums1中的第k＋1个
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0;

        while (j < n) {
            if (nums2[j] > nums1[i] && i < m) i++;
            else {
//                insert(nums2[j],nums1, i);
                for (int h = m - 1; h >= i; h--) {
                    nums1[h + 1] = nums1[h];
                }
                nums1[i] = nums2[j];
                m++;
                j++;
            }

        }

    }

    public void insert(int x, int[] nums1, int k) {
        for (int h = nums1.length - 1; h >= k; h--) {
            nums1[h + 1] = nums1[h];
        }
        nums1[k] = x;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 7;
        int[] b = new int[]{0, 2, 4, 6, 8};

        new MergeSortedArray().merge(a, 4, b, 5);

        Util.printArray(a);
    }
}
