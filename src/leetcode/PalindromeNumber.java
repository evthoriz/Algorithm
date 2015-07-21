package leetcode;

/**
 * Created by evtHoriz on 15/3/9.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int t = x;
        int palindome = 0;
        while (x > 0) {
            palindome = palindome * 10 + x % 10;
            x /= 10;
            System.out.println(x);
        }
        return palindome == t;

    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(2147483647));
    }
}
