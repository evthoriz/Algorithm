package leetcode;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int x = 0;
        for (int i = 0; i<32; i++) {
            x += (n & 1);
            n >>>= 1;
            if (i < 31)
                x = x<<1;

        }
        return x;
    }

    public static void main(String[] args) {

        System.out.println(new ReverseBits().reverseBits(1));
        System.out.println(Math.pow(2, 30));
        System.out.println(Math.pow(2,31));
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(1<<31);
        System.out.println(new ReverseBits().reverseBits(Integer.MAX_VALUE+1));

    }
}
