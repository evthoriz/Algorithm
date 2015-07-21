package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/3/8.
 */
public class ZigZagConversion {
    public String convert(String text, int nRows) {
        if (text.length() <= nRows || nRows==1) {
            return text;
        }
        char[] charArr = text.toCharArray();
        List<Character>[] list = new List[nRows];
        for (int i = 0; i < nRows; i++) {
            list[i] = new ArrayList<Character>();
        }
        boolean flag = true;
        int idx = 0;
        for (int i = 0; i < charArr.length; i++) {
            list[idx].add(charArr[i]);
            if (flag) {
                idx++;
            } else {
                idx--;
            }
            if (idx == nRows - 1 || idx == 0) {
                flag = !flag;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (List<Character> l : list) {
            for (Character c : l) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
    }
}
