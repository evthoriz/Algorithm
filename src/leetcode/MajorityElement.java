package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 * tips: 先排序，去中间位置的值即可。O(nlogn)
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length==1) return nums[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer x = map.get(nums[i]);
            if (x != null) {
                if (x + 1 > nums.length / 2) return nums[i];
                map.put(nums[i], x + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return -1;
    }
}
