package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by evtHoriz on 15/4/22.
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return l;
        }
        l.add("");
        for (char digit : digits.toCharArray()) {
            int n = (digit == '7' || digit == '9') ? 4 : 3;
            char ch = (char) ((digit - '2') * 3 + 'a');
            if (digit > '7') {
                ch++;
            }
            List<String> tmp = new ArrayList<String>();
            for (int i = 0; i < l.size(); i++) {
                for (int j = 0; j < n; j++) {
                    tmp.add(l.get(i) + (char)(ch+j));
                }
            }
            l = tmp;
        }
        return l;
    }

    public static void main(String[] args) {
        // 2:a b c
        // 3:d e f
        // 4:g h i
        System.out.println(new LetterCombinations().letterCombinations("78"));
    }


}
