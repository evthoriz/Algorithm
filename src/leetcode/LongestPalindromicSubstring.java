package leetcode;

import java.util.Arrays;

/**
 * Created by evtHoriz on 15/3/8.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int maxLen = 0;
        int midCharIdx = 0;

        for (int i = 0; i < charArr.length; i++) {
            int curLen = 0;
            int mirror = 0;
            for (int j = i; j >= 0; j--) {
                mirror = i + i - j;
                if (mirror >= charArr.length) {
                    break;
                }
                if (charArr[j] == charArr[mirror]) {
                    if (++curLen > maxLen) {
                        maxLen = curLen;
                        midCharIdx = i;
                    }
                } else {
                    break;
                }
            }
        }
        String odds = s.substring(midCharIdx - (maxLen - 1), midCharIdx + (maxLen - 1) + 1);

        maxLen = 0;
        midCharIdx = 0;

        for (int i = 0; i < charArr.length; i++) {
            int curLen = 0;
            int mirror = 0;
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    mirror = i + i - j;
                } else {
                    mirror = i + i - j - 1;
                }
                if (mirror >= charArr.length) {
                    break;
                }
                if (charArr[j] == charArr[mirror]) {
                    if (++curLen > maxLen) {
                        maxLen = curLen;
                        midCharIdx = i;
                    }
                } else {
                    break;
                }
            }
        }

        String evens = s.substring(midCharIdx - (maxLen - 1), midCharIdx + (maxLen - 1));

        return odds.length() > evens.length() ? odds : evens;

    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("bbba"));
    }
}
