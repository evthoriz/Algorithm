package practise.backtrace;

/**
 * Created by evtHoriz on 15/5/2.
 */
public class Permutation {

    public static void main(String[] args) {
        new Permutation().backtrace(0);
    }

    public static int N = 3;
    public static boolean[] used = new boolean[N];
    public static int[] solution = new int[N];
    public static int[] candidate = new int[]{1, 2, 3};

    public void backtrace(int n) {
        if (n == N) {
            utils.Util.printArray(solution);
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                solution[n] = candidate[i];
                backtrace(n + 1);
                used[i] = false;
            }
        }

    }
}
