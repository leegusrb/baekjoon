import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q2143 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] numA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Long> sumA = makeSumList(st, numA, n);

        int m = Integer.parseInt(br.readLine());
        int[] numB = new int[m];
        st = new StringTokenizer(br.readLine());
        ArrayList<Long> sumB = makeSumList(st, numB, m);

        long cnt = cntT(sumA, sumB, T);

        System.out.println(cnt);
    }

    private static ArrayList<Long> makeSumList(StringTokenizer st, int[] arr, int m) {
        ArrayList<Long> sumList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            long sum = 0L;
            for (int j = i; j < m; j++) {
                sum += arr[j];
                sumList.add((sum));
            }
        }
        sumList.sort(Comparator.naturalOrder());

        return sumList;
    }

    private static long cntT(ArrayList<Long> sumA, ArrayList<Long> sumB, int T) {
        int s = 0;
        int e = sumB.size() - 1;
        long cnt = 0;

        while (s < sumA.size() && e >= 0) {
            long a = sumA.get(s);
            long b = sumB.get(e);

            if (a + b == T) {
                long cntA = 0;
                long cntB = 0;
                while (s < sumA.size() && sumA.get(s) == a) {
                    cntA++;
                    s++;
                }
                while (e >= 0 && sumB.get(e) == b) {
                    cntB++;
                    e--;
                }
                cnt += cntA * cntB;
            } else if (a + b < T) {
                s++;
            } else {
                e--;
            }
        }
        return cnt;
    }
}