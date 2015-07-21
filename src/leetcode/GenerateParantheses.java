package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/5/2.
 */
public class GenerateParantheses {


    public static void main(String[] args) {
        System.out.println(new GenerateParantheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrace("(", 1, 0, result, n);
        return result;
    }

    public static  int N = 3;
    public void backtrace(String str, int open, int close, List<String> result, int N) {
        if (str.length() == 2 * N) {
            result.add(new String(str));
            return;
        }

        if (open < N) {
            backtrace(str + "(", open + 1, close, result, N);
        }
        if (close < open) {
            backtrace(str + ")", open, close + 1, result, N);
        }
    }
}
