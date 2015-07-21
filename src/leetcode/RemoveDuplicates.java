package leetcode;

/**
 * Created by evtHoriz on 15/5/10.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0, 1, 1, 2, 3, 3, 3, 4, 4, 5, 6,6}));
    }
    // 0 1 2 3 3 4 5 6
    // 0 1 2 3 4 3 5 6


    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int prev = 0;
        int next = 1;
        for (; next < nums.length; next++) {
            if (nums[next] != nums[prev]) {
                nums[++prev] = nums[next];
            }
        }
        return prev + 1;
    }

}
