package leetcode;

import java.util.Map;

/**
 * Created by evtHoriz on 15/3/8.
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            x = -x;
            negative = true;
        }
        String s = String.valueOf(x);
        int r = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        try {
            r = Integer.valueOf(sb.toString());
        } catch (Exception e) {
            return 0;
        }
        return negative ? -1 * r : r;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(10100));
    }
}
