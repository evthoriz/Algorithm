package leetcode;

import utils.Util;

import java.util.Arrays;

/**
 * Created by evtHoriz on 15/3/5.
 */
public class MedianInArrays {
    public static void main(String[] args) {
        System.out.println(new MedianInArrays().findMedianSortedArrays(new int[]{2}, new int[]{1,3,4}));
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        Util.printArray(A);
        Util.printArray(B);
        int m = A.length;
        int n = B.length;
        if (m == 0)
            return n % 2 != 0 ? B[n / 2] : (B[n / 2 - 1] + B[n / 2]) / 2.0;
        if (n == 0)
            return m % 2 != 0 ? A[m / 2] : (A[m / 2 - 1] + A[m / 2]) / 2.0;
        if( m ==1) {
            if(n%2!=0) {
                if (B[n/2]==A[0]) {
                    return A[0];
                } else if (B[n/2]>A[0]&&B[n/2-1]<A[0]) {
                    return (B[n/2] + A[0])/2.0;
                } else if (B[n/2]>A[0]) {
                    return (B[n/2]+B[n/2-1])/2.0;
                } else if (B[n/2]<A[0] && B[n/2+1]>A[0]) {
                    return (B[n/2] + A[0])/2.0;
                } else if (B[n/2]<A[0]) {
                    return (B[n/2]+B[n/2+1])/2.0;
                }
            }
        }

        int l = m + n;
        double midA = m % 2 != 0 ? A[m / 2] : (A[m / 2 - 1] + A[m / 2]) / 2.0;
        double midB = n % 2 != 0 ? B[n / 2] : (B[n / 2 - 1] + B[n / 2]) / 2.0;

        int cutP = m > n ? n / 2 : m / 2;



        System.out.println("l:" + l + ",m:" + m + ",n:" + n + ",midA:" + midA + ",midB:" + midB + ",cutP:" + cutP);
        if (midA == midB) {
            return midA;
        } else if (midA < midB) {
            return findMedianSortedArrays(Arrays.copyOfRange(A, cutP, m), Arrays.copyOfRange(B, 0, n - cutP));
        } else {
            return findMedianSortedArrays(Arrays.copyOfRange(B, cutP, n), Arrays.copyOfRange(A, 0, m - cutP));
        }

    }
}
