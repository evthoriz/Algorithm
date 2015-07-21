package leetcode;

/**
 * Created by evtHoriz on 15/7/16.
 * Email: evthoriz@gmail.com
 *
 * tips: 2的指数 的二进制 是一个1跟着一堆0， 减一后，1变成0，后面0变成1，&一下等于0. 下面三种方法中此种最快。其余两种一样。
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        for (int i = 2; i <= n && i>0; i += i) {
            if (n == i) return true;
        }
        return false;
    }

    public boolean isPowerOfTwo2(int n) {
        return n>0&&(n&n-1)==0;
    }

    public boolean isPowerOfTwo3(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 30));
        System.out.println(Math.pow(2, 31));
        System.out.println(Math.pow(2, 32));
        System.out.println(new PowerofTwo().isPowerOfTwo2(1073741823));
        System.out.println(new PowerofTwo().isPowerOfTwo3(1073741824));
        System.out.println(1073741824+1073741824);
    }
}
