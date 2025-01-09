package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10942 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] P = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            P[i][i] = true;
        }

        for (int i = 1; i <= N - 1; i++) {
            if (arr[i] == arr[i + 1])
                P[i][i + 1] = true;
        }

        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (arr[j] == arr[j + i] && P[j + 1][j + i - 1])
                    P[j][j + i] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (P[S][E])
                bw.write("1\n");
            else
                bw.write("0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
