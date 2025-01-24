package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];

        for (int t = 1; t < N; t++) {
            for (int start = 0; start < N - t; start++) {
                dp[start][start + t] = Integer.MAX_VALUE;
                for (int m = start; m < start + t; m++) {
                    dp[start][start + t] = Math.min(dp[start][start + t], dp[start][m] + dp[m + 1][start + t] + arr[start][0] * arr[m][1] * arr[start + t][1]);
                }
            }
        }

        System.out.println(String.valueOf(dp[0][N - 1]));
    }
}
