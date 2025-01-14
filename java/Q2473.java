package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2473 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long[] res = new long[3];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long mn = Long.MAX_VALUE;

        for (int m = 1; m < N - 1; m++) {
            int i = 0, j = N - 1;

            while (i < m && m < j) {
                long s = arr[i] + arr[m] + arr[j];

                if (Math.abs(s) < mn) {
                    mn = Math.abs(s);
                    res[0] = arr[i];
                    res[1] = arr[m];
                    res[2] = arr[j];
                }

                if (s < 0) {
                    i++;
                } else if (s > 0) {
                    j--;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            bw.write(String.valueOf(res[i]) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
