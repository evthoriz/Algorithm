package leetcode;

/**
 * Created by evtHoriz on 15/5/10.
 */
public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        if (nums.length < 1) {
            return nums.length;
        }
        int prev = 0;
        for (int next = 0; next < nums.length; next++) {
            if (nums[next] != val) {
                nums[prev++] = nums[next];
            }
        }
        utils.Util.printArray(nums);
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElements().removeElement(new int[]{3,2,1,2}, 2));
    }
}
