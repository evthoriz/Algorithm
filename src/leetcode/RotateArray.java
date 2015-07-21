package leetcode;

import utils.Util;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 1 || nums.length == 0) return;
        k = k % nums.length;


        int[] left = new int[k];
        for (int i = 0; i < k; i++) {
            left[i] = nums[nums.length - k + i];
        }

        for (int j = nums.length - 1, i = k - 1; j >= 0; j--, i--) {
            if (j - k >= 0) {
                nums[j] = nums[j - k];
            } else {
                nums[j] = left[j];
            }
        }

        Util.printArray(left);


    }

    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(in, 2);
        Util.printArray(in);
    }


}
