package leetcode;

/**
 * Created by evtHoriz on 15/8/14.
 * Email: evthoriz@gmail.com
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {

        if (s == null) {
            return 0;
        }

        int len = 0;
        int lastLen = 0;

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c != ' ') {
                len++;
                lastLen = len;
            } else {
                len = 0;
            }
        }

        return len == 0 ? lastLen : len;
    }
}
