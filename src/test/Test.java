package test;

import java.util.Observable;

/**
 * Created by evtHoriz on 15/4/23.
 */
public class Test {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = a;
        System.out.println(a.equals(b));
        Object c = new Object();
        b = c;
        System.out.println(a.equals(b));
    }
}
