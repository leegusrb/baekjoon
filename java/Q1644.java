import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1644 {
    static int N;
    static boolean[] num;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            num[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (num[i]) {
                for (int j = i * i; j <= N; j += i)
                    num[j] = false;
            }
        }

        for (int i = 2; i <= N; i++)
            if (num[i]) list.add(i);

        int cnt = cntSum();

        System.out.println(cnt);
    }

    private static int cntSum() {
        int cnt = 0;
        int s = 0;
        int e = 0;
        int sum = 0;

        while (e < list.size()) {
            if (sum < N)
                sum += list.get(e++);
            else
                sum -= list.get(s++);
            if (sum == N) cnt++;
        }

        while (s < list.size() && sum > N) {
            sum -= list.get(s++);
            if (sum == N) cnt++;
        }

        return cnt;
    }
}