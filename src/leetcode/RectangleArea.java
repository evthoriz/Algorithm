package leetcode;

/**
 * Created by evtHoriz on 15/7/19.
 * Email: evthoriz@gmail.com
 */
public class RectangleArea {
    public int computeArea(int left1, int bottom1, int right1, int top1, int left2, int bottom2, int right2, int top2) {
        int rect1 = (right1 - left1) * (top1 - bottom1);
        int rect2 = (right2 - left2) * (top2 - bottom2);

        int intersize = 0;
        if (left1 < left2 && right1 > left2) {


        } else if (left2<left1 && right2 > left1) {

        }
        return rect1 + rect2 - intersize;
    }

    public static void main(String[] args) {

    }
}
