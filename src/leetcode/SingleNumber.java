package leetcode;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by evtHoriz on 15/7/20.
 * Email: evthoriz@gmail.com
 * tips: xor 两次同一个数，就抵消掉了。xor有传递性。
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int tmp = 0;
        for (int i : nums) {
            tmp ^= i;
        }
        return tmp;
    }
}
