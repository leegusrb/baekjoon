package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> G = new ArrayList<>();
            int[] time = new int[N + 1];
            boolean[] isFirst = new boolean[N + 1];

            for (int j = 0; j <= N; j++) {
                G.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(isFirst, true);
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                G.get(from).add(to);
                isFirst[to] = false;
            }

            Queue<Integer> S = new LinkedList<>();
            int[] res = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                if (isFirst[j]) {
                    S.add(j);
                    res[j] = time[j];
                }
            }

            while (!S.isEmpty()) {
                int cur = S.poll();

                for (int next : G.get(cur)) {
                    if (res[cur] + time[next] > res[next]) {
                        res[next] = res[cur] + time[next];
                        S.add(next);
                    }
                }
            }

            int dest = Integer.parseInt(br.readLine());

            bw.write(String.valueOf(res[dest]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
