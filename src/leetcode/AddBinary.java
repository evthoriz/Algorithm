package leetcode;

/**
 * Created by evtHoriz on 15/7/20.
 * Email: evthoriz@gmail.com
 */
public class AddBinary {

    public String addBinary2(String a, String b) {
        int m = a.length() ;
        int n = b.length() ;
        int tmp = 0;
        String res = "";
        while (m + n > 0) {
            tmp += m > 0 ? a.charAt(--m) - '0' : 0;
            tmp += n > 0 ? b.charAt(--n) - '0' : 0;

            res = tmp % 2 + res;
            tmp /= 2;
        }
        return (tmp == 0) ? res : "1" + res;
    }

    public String addBinary(String a, String b) {
        if (a == null || b == null) return null;

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean flag = false;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                if (flag) {
                    sb.insert(0, '1');
                } else {
                    sb.insert(0, '0');
                }
                flag = true;
            } else if (a.charAt(i) != b.charAt(j)) {
                if (flag) {
                    sb.insert(0, '0');
                    flag = true;
                } else {
                    sb.insert(0, '1');
                    flag = false;
                }
            } else {
                if (flag) {
                    sb.insert(0, '1');
                } else {
                    sb.insert(0, '0');
                }
                flag = false;
            }
            i--;
            j--;
        }

        while (j >= 0) {
            if (flag) {
                if (b.charAt(j) == '1') {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                    flag = false;
                }
            } else {
                sb.insert(0, b.charAt(j));
            }
            j--;
        }

        while (i >= 0) {
            if (flag) {
                if (a.charAt(i) == '1') {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                    flag = false;
                }
            } else {
                sb.insert(0, a.charAt(i));
            }
            i--;

        }

        if (flag) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary2("11", "111"));
    }
}
