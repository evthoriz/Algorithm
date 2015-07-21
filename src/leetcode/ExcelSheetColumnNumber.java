package leetcode;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {

        int sum = 0;
        for (char c : s.toCharArray()) {
            sum = sum * 26 +  (c - 'A')+1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
    }
}
