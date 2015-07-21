package leetcode;

/**
 * Created by evtHoriz on 15/7/20.
 * Email: evthoriz@gmail.com
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s==null) return false;
        s = s.toLowerCase();
        int prev = 0, post = s.length() - 1;

        while (prev < post) {
            if (notNum(s.charAt(prev))) {
                prev++;
                continue;
            }
            if (notNum(s.charAt(post))) {
                post--;
                continue;
            }

            if (s.charAt(prev)!=s.charAt(post)) return false;
            prev++;
            post--;

        }

        return true;
    }

    boolean notNum(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c<='9') return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("1a2"));
    }
}
