package practise.backtrace;

/**
 * Created by evtHoriz on 15/5/2.
 */
public class EightQueen {

    public static void main(String[] args) {
        new EightQueen().backtrace(0);
        System.out.println("count:" + count);
    }

    public static int N = 16;
    public static int solution[] = new int[N];
    public static boolean[] my = new boolean[N];
    public static boolean[] md1 = new boolean[2 * N - 1];
    public static boolean[] md2 = new boolean[2 * N - 1];
    public static int count = 0;

    public void backtrace(int x) {
        if (x == N) {
            count++;
            utils.Util.printArray(solution);
        }

        for (int y = 0; y < N; y++) {
            int d1 = x + y;
            int d2 = (x - y + 2 * N - 1) % (2 * N - 1);
            if (!my[y] && !md1[d1] && !md2[d2]) {
                my[y] = md1[d1] = md2[d2] = true;
                solution[x] = y;
                backtrace(x + 1);
                my[y] = md1[d1] = md2[d2] = false;
            }
        }


    }
}
