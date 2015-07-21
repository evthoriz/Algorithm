package leetcode;

/**
 * Created by evtHoriz on 15/5/10.
 * tips: 1. 对于字符串类型要先确定对于空字符串和NULL的处理规则。
 * 2. 考虑减少次数时从外面的循环开始考虑。
 */

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) return 0;
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int idx = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {

                continue;
            } else {
                idx = i;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        idx = -1;
                        break;
                    }
                }
                if (idx != -1) {
                    return idx;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("", ""));
    }
}
