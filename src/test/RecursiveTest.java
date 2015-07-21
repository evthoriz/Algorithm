package test;

/**
 * Created by evtHoriz on 15/7/15.
 * Email: evthoriz@gmail.com
 * <p/>
 * <p/>
 * ------------- howManyNumBeforeMe --------------
 * 这个简单的例子展示了递归的一种使用场景：要求当前解，需要先获得前一个解。
 * 这种情况用递归很好理解，前一个解的求取方式和当前解的求取方式是一样的，故可以不断调用自身，直到baseline终止时往上逐层返回。
 *
 * ------------ howManyNumFromZeroToMe ------------
 * 这个简单的例子展示了另一种使用场景：当前解可以从头开始不断迭代。而这种迭代都是采用一样的逻辑。
 * 这种情形和循环迭代的理解是一样的。因为逻辑的不断重复，完全可以使用调用自己来替代。
 */
public class RecursiveTest {
    public static void main(String[] args) {


        System.out.println(howManyNumBeforeMe(5));
        System.out.println(howManyNumFromZeroToMe(5, 0, 0));

    }

    public static int howManyNumFromZeroToMe(int n, int x, int nums) {
        if (x == n) {
            return nums;
        }
        nums += 1;
        return howManyNumFromZeroToMe(n, x + 1, nums);
    }

    public static int howManyNumBeforeMe(int n) {
        if (n == 0) {
            return 0;
        }
        return howManyNumBeforeMe(n - 1) + 1;
    }

}
