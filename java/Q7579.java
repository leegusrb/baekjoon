package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] m = new int[N];
        int[] c = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            sum += c[i];
        }

        int[][] bag = new int[N][sum + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < c[i]) {
                    bag[i][j] = i == 0 ? 0 : bag[i - 1][j];
                } else {
                    bag[i][j] = i == 0 ? m[i] : Math.max(bag[i - 1][j], m[i] + bag[i - 1][j - c[i]]);
                }
            }
        }

        for (int i = 0; i <= sum; i++) {
            if (bag[N - 1][i] >= M) {
                System.out.println(i);
                break;
            }
        }

        br.close();
    }
}
