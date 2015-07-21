package leetcode;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) return 0;
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");

        for (int i = 0; i < v1s.length && i < v2s.length; i++) {
            int v1 = Integer.parseInt(v1s[i]);
            int v2 = Integer.parseInt(v2s[i]);
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
        }
        if (v1s.length > v2s.length) {
            for (int i = v2s.length; i < v1s.length; i++) {
                if (Integer.parseInt(v1s[i]) != 0) return 1;
            }
        } else if (v1s.length < v2s.length) {
            for (int i = v1s.length; i < v2s.length; i++) {
                if (Integer.parseInt(v2s[i]) != 0) return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("1.0", "1"));
    }
}
