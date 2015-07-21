package leetcode;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by evtHoriz on 15/7/14.
 * Email: evthoriz@gmail.com
 * <p/>
 * tips: 即求几个divisor相加的和sum能满足 sum == divident || sum + divisor > divident && sum - divisor < divident
 * 效率考虑 每次不只加一个，而是加自身。每次累加，计数也是double了。
 * <p/>
 * 先考略清楚边界条件，可能溢出的情形比如：
 * Interger.MIN_VALUE / -1
 */
public class DivideTwoInt {
    public static void main(String[] args) {

        System.out.println(Integer.MIN_VALUE - 1);

        System.out.println(divide(-2147483648, 2) == -1073741824);
        System.out.println(divide(-2147483648, -1) == 2147483647);//overflow
        System.out.println(divide(-2147483648, 1) == -2147483648);
        System.out.println(divide(-2147483648, -3) == 715827882);
        System.out.println(divide(1, 2) == 0);
        System.out.println(divide(1004958205, -2137325331) == 0);

    }

    public static int divide(int divident, int divisor) {

        boolean negative = false;
        if (divisor == 0) return Integer.MAX_VALUE;
        else if (divisor == 1) return divident;
        else if (divisor == -1 && divident == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        else if (divident == 0) return 0;
        else if (divident == divisor) return 1;
        else if (divisor == Integer.MIN_VALUE) return 0;

        if (divisor > 0) {
            divisor = -divisor;
            negative = !negative;
        }
        if (divident > 0) {
            divisor = -divisor;
            negative = !negative;
        }


        if (divident > divisor) return 0;

        int sum = divisor;
        int count = 1;

        int cursum = sum;
        int curcount = count;
        while (true) {

            if (sum == divident || (sum + divisor < divident) && sum > divident) {
                break;
            } else {
                if (sum + cursum >= divident && sum + cursum < 0) {
                    sum += cursum;
                    count += curcount;
                    cursum += cursum;
                    curcount += curcount;
                } else {
                    cursum = divisor;
                    curcount = 1;
                }
            }

        }
        return (negative ? 0 - count : count);

    }


}
