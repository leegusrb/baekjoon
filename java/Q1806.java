package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        int i = 0, j = 1, res = Integer.MAX_VALUE;
        while (i <= N && j <= N) {
            int s = sum[j] - sum[i];
            if (s >= S) {
                res = Math.min(res, j - i);
                i++;
            } else {
                j++;
            }
        }

        bw.write(String.valueOf(res != Integer.MAX_VALUE ? res : 0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
