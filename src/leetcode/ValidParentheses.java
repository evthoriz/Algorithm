package leetcode;

/**
 * Created by evtHoriz on 15/4/23.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] ar = new char[s.length()];
        int idx = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                ar[idx++] = c;
            } else if (c == ')') {
                if (idx == 0 || ar[--idx] != '(') {
                    return false;
                }
            } else if (c == '}') {
                if (idx == 0 || ar[--idx] != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (idx == 0 || ar[--idx] != '[') {
                    return false;
                }

            } else {
                //
            }
        }
        if (idx == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("([)]"));
    }
}
