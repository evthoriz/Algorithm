package leetcode;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 * tips: 5* 2 = 10;阶乘里有出现多少5就能至少有多少0，同理，出现25（在出现5的基础上还可以有），出现125等等时递推。
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int sum = 0;
        int tmp = 0;
        while (n / 5 > 0) {
            tmp = n / 5;
            sum += tmp;
            n = tmp;
        }
        return sum;
    }
}
