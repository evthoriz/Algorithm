package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by evtHoriz on 15/8/14.
 * Email: evthoriz@gmail.com
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        qsort(schars, 0, schars.length - 1);
        qsort(tchars, 0, tchars.length - 1);

        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i]) {
                return false;
            }
        }
        return true;
    }

    public void qsort(char[] chars, int lo, int hi) {
        if (lo < hi) {
            int i = lo, j = hi;
            char x = chars[i];

            while (i < j) {
                while (i < j && chars[j] > x) {
                    j--;
                }

                if (i < j) {
                    chars[i] = chars[j];
                    i++;
                }

                while (i < j && chars[i] < x) {
                    i++;
                }
                if (i < j) {
                    chars[j] = chars[i];
                    j--;
                }
            }

            chars[i] = x;
            qsort(chars, lo, i - 1);
            qsort(chars, i + 1, hi);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
    }


}
