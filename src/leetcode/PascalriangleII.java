package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evtHoriz on 15/7/20.
 * Email: evthoriz@gmail.com
 */
public class PascalriangleII {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0) return list;

        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);

        for (int i = 1; i < rowIndex+1; i++) {
            List<Integer> l = new ArrayList<Integer>();
            l.add(1);
            for (int j = 1; j < i; j++) {
                l.add(prev.get(j-1) + prev.get(j));
            }
            l.add(1);
            prev = l;

        }
        return  prev;
    }

    public static void main(String[] args) {
        System.out.println(new PascalriangleII().getRow(0));
        System.out.println(new PascalriangleII().getRow(1));
        System.out.println(new PascalriangleII().getRow(2));
        System.out.println(new PascalriangleII().getRow(3));
    }

}
