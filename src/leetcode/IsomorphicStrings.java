package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 *
 * tips: hashMap 的 containsValue 。
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        int len = sa.length;

        Map<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(sa[i])) {
                if (!map.get(sa[i]).equals(ta[i])) return false;
            } else {
                if (map.containsValue(ta[i])) return false;
                map.put(sa[i], ta[i]);
            }
        }
        return true;
    }
}
