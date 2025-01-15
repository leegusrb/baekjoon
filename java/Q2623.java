package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2623 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        int[] dest = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int from = 0, to = 0;
            for (int j = 0; j < n; j++) {
                to = Integer.parseInt(st.nextToken());
                if (j != 0) {
                    G.get(from).add(to);
                    dest[to]++;
                }
                from = to;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (dest[i] == 0) {
                Q.add(i);
            }
        }

        while (!Q.isEmpty()) {
            int cur = Q.poll();
            res.add(cur);

            for (int next : G.get(cur)) {
                dest[next]--;
                if (dest[next] == 0) {
                    Q.add(next);
                }
            }
        }

        if (res.size() == N) {
            for (int i = 0; i < N; i++) {
                bw.write(String.valueOf(res.poll()) + "\n");
            }
        } else {
            bw.write("0\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
