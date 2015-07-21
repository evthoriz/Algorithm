package leetcode;

import java.util.HashSet;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        if (n <= 0) return false;

        HashSet<Integer> set = new HashSet<Integer>();
        int sum = 0;
        while (true) {
            if (set.contains(n)) break;
            sum = addSquare(n);
            set.add(n);
            if (n == 1) return true;
            n = sum;
        }

        return false;
    }

    public int addSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n/ 10;
            sum += d*d;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(20));
    }
}
