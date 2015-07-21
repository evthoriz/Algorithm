package leetcode;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 * <p/>
 * tips: n&(n-1)每次将最后一位1给消掉。
 */
public class Numberof1Bits {

    public int hammingWeight2(int n) {
        int count = 0;
        for (int i =0; i<32; i++) {
            if ((n & 1) == 1) count++;
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(new Numberof1Bits().hammingWeight(Integer.MAX_VALUE + 1));
    }
}
