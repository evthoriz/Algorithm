package leetcode;

/**
 * Created by evtHoriz on 15/3/8.
 */
public class StringToInteger {
    public int atoi(String str) {
        char[] charArr = str.toCharArray();
        int i = 0;
        int sign = 1;
        int base = 0;
        while (charArr[i] == ' ') i++;
        if (charArr[i]=='-' || charArr[i]=='+') {
            sign = 1 - 2 * (charArr[i++] == '-'?1:0);
        }
        while (i<charArr.length && charArr[i] >= '0' && charArr[i] <= '9') {
            if (base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && charArr[i] - '0' > 7)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            base = 10 * base + (charArr[i++] - '0');
        }
        return base * sign;
    }


    public static void main(String[] args) {
        System.out.println(new StringToInteger().atoi("1"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(0xffffffff);
    }
}
