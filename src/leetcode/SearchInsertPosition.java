package leetcode;

/**
 * Created by evtHoriz on 15/8/14.
 * Email: evthoriz@gmail.com
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return divideAndSearch(nums, 0, nums.length - 1, target);
    }

    public int divideAndSearch(int[] nums, int lo, int hi, int target) {

        if (lo > hi) {
            return lo;
        }
        int mid = (lo + hi) / 2;

        if (nums[mid] < target) {
            return divideAndSearch(nums, mid + 1, hi, target);
        }
        if (nums[mid] > target) {
            return divideAndSearch(nums, lo, mid - 1, target);
        }
        return mid;
    }


}
