package leetcode;

import java.util.Arrays;

/**
 * Created by evtHoriz on 15/8/13.
 * Email: evthoriz@gmail.com
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {

        qsort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i += 3) {
            if (i + 2 >= nums.length || nums[i] != nums[i + 2]) {
                return nums[i];
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        int tempNum = 0;
        for (int i = 1; i < nums.length; i++) {
            tempNum = nums[0] & (tempNum ^ nums[i]);
            nums[0] = tempNum | (nums[0] ^ nums[i]);
        }
        return nums[0];
    }

    public static void qsort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int i = lo;
            int j = hi;

            int x = nums[i];

            while (i < j) {
                while (i < j && nums[j] > x) {
                    j--;
                }

                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }

                while (i < j && nums[i] < x) {
                    i++;
                }

                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }

            nums[i] = x;
            qsort(nums, lo, i - 1);
            qsort(nums, i + 1, hi);
        }

    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber2(new int[]{3,3,3,5,5,2,2,2}));

    }
}
