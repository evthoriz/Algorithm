package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums==null || k <=0)  return false;

        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i<len; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i])<=k) return true;
                else map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
