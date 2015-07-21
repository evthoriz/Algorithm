package leetcode;

import utils.Util;

import java.util.*;

/**
 * Created by evtHoriz on 15/4/20.
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{0,0,0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        Util.printArray(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[j] + nums[k] + nums[i] == 0) {
                    List<Integer> il = new ArrayList<Integer>();
                    il.add(nums[i]);
                    il.add(nums[j]);
                    il.add(nums[k]);
                    l.add(il);
                    while (j < k && nums[j] == nums[j+1]) j++;
                    while (j < k && nums[k] == nums[k-1]) k--;
                    j++; k--;
                } else if  (nums[j] + nums[k] + nums[i] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return l;
    }
}
