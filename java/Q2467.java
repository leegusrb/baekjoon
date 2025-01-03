package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2467 {
    static int N;
    static int[] arr;
    static int[] isVisit = new int[2];
    static int mn = Integer.MAX_VALUE;
    static int[] res = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int x = 0, y = N - 1;
        while (x < y) {
            int s = arr[x] + arr[y];
            
            if (Math.abs(s) < mn) {
                mn = Math.abs(s);
                res[0] = arr[x];
                res[1] = arr[y];
            }

            if (s < 0) {
                x++;
            } else if (s > 0) {
                y--;
            } else {
                break;
            }
        }

        for (int i = 0; i < 2; i++ )
            bw.write(String.valueOf(res[i]) + " ");
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
