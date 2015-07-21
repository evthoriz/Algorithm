package leetcode;

import java.util.BitSet;

/**
 * Created by evtHoriz on 15/7/16.
 * Email: evthoriz@gmail.com
 *
 * 求素素个树，用筛选法，假设所有都是素数，然后从2开始，筛选掉2的倍数。继续下去。
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            isPrime[i] = true;
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = i + i; j < n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(100000000));
    }
}
