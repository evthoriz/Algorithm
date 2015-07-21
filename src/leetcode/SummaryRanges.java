package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/7/16.
 * Email: evthoriz@gmail.com
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<String>();
        if (nums.length == 0) return result;
        StringBuilder sb = new StringBuilder(String.valueOf(nums[0]));
        int acc = 1;
        for (int i = 1; i<nums.length; i++) {
            if (nums[i]==nums[i-1]+1) {
                acc++;
                continue;
            } else {
                if (acc>1) {
                    sb.append("->").append(nums[i-1]+"");
                }
                result.add(sb.toString());
                sb = new StringBuilder(String.valueOf(nums[i]));
                acc = 1;
            }
        }
        if (acc>1) {
            sb.append("->").append(nums[nums.length-1]+"");
        }
        result.add(sb.toString());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0,1,2,4,5,7}));
    }




}
