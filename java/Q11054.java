package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11054 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        int[] front = new int[N];
        int[] back = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (ar[i] > ar[j])
                    front[i] = Math.max(front[i], front[j] + 1);
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (ar[i] > ar[j])
                    back[i] = Math.max(back[i], back[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, front[i] + back[i] + 1);
        }

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
