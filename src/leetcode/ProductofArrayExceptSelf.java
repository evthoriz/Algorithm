package leetcode;

/**
 * Created by evtHoriz on 15/8/14.
 * Email: evthoriz@gmail.com
 */
public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        if (nums == null) {
            return null;
        }
        int[] result = new int[nums.length];

        if (nums.length == 1) {
            return result;
        }

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int rightProduct = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] *= rightProduct;
            rightProduct *= nums[j];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ProductofArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4}));
    }

}
