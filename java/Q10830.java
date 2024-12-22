package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10830 {
    static int N;
    static long B;
    static long[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] res = cal(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(String.valueOf(res[i][j] % 1000) + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static long[][] cal(long n) {
        if (n == 1) {
            return arr;
        }

        long[][] res;
        long[][] tmp = cal(n / 2);

        if (n % 2 == 1) {
            res = mul(tmp, tmp);
            res = mul(res, arr);
        } else {
            res = mul(tmp, tmp);
        }

        return res;
    }

    static long[][] mul(long[][] a, long[][] b) {
        long[][] res = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
                res[i][j] %= 1000;
            }
        }
        
        return res;
    }
}
