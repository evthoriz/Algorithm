package leetcode;

import utils.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by evtHoriz on 15/4/22.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if (num.length < 4) {
            return l;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > j + 1 && num[j] == num[j - 1]) continue;
                int lo = j + 1, hi = num.length - 1;
                int re = target - num[i] - num[j];
                while (lo < hi) {
                    if (num[lo] + num[hi] == re) {
                        List<Integer> il = new ArrayList<Integer>();
                        il.add(num[i]);
                        il.add(num[j]);
                        il.add(num[lo]);
                        il.add(num[hi]);
                        l.add(il);
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] > re) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{0, 0, 0, 0}, 0));
    }
}
