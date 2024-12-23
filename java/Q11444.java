package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11444 {
    static long[][] A = {{1, 1}, {1, 0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        if (n == 0 || n == 1) {
            bw.write(String.valueOf(n) + "\n");
        } else {
            long[][] res = sq(n - 1);

            bw.write(String.valueOf(res[0][0]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static long[][] sq(long n) {
        if (n == 1) {
            return A;
        }

        long[][] tmp = sq(n / 2);
        if (n % 2 == 1) {
            return sol(sol(tmp, tmp), A);
        } else {
            return sol(tmp, tmp);
        }
    }

    static long[][] sol(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                    res[i][j] %= 1_000_000_007;
                }
            }
        }
        return res;
    }
}
