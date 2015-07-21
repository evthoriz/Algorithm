package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/7/20.
 * Email: evthoriz@gmail.com
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) return result;
        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        result.add(prev);
        for (int i = 1; i < numRows; i++) {
            int row = i + 1;
            List<Integer> l = new ArrayList<Integer>();
            l.add(1);
            for (int j = 1; j < row-1; j++) {
                l.add(prev.get(j-1) + prev.get(j));
            }
            l.add(1);
            prev = l;
            result.add(l);

        }
        return  result;
    }

    public static void main(String[] args) {
        new PascalTriangle().generate(1);
    }
}
