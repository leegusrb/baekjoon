import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1106 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C + 100];

        for (int i = 0; i < C + 100; i++) {
            dp[i] = Integer.MAX_VALUE / 2;
        }

        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            st  = new StringTokenizer(br.readLine());
            int cost =  Integer.parseInt(st.nextToken());
            int customer =  Integer.parseInt(st.nextToken());

            for (int j = customer; j < C + 100; j++) {
                dp[j] = Math.min(dp[j], dp[j - customer] + cost);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = C; i < C + 100; i++) {
            res = Math.min(res, dp[i]);
        }

        System.out.println(res);
    }
}