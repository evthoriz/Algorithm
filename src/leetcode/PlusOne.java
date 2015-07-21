package leetcode;

/**
 * Created by evtHoriz on 15/7/20.
 * Email: evthoriz@gmail.com
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null) return null;

        int len = digits.length;

        boolean flag = false;
        digits[len - 1] = digits[len - 1] + 1;

        for (int i = len - 1; i >= 0; i--) {
            digits[i] = digits[i] + (flag ? 1 : 0);
            if (digits[i] > 9) {
                digits[i] = 0;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
