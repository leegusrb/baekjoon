package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2166 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];

        long res = 0;
        for (int i = 0; i < N; i++) {
            res += (long) arr[i][0] * arr[i + 1][1] - (long) arr[i + 1][0] * arr[i][1];
        }
        res = Math.abs(res);
        
        System.out.printf("%.1f\n", res / 2.0);
    }
}
