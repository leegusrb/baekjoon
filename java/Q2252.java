package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        int[] inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            G.get(from).add(to);
            inDegree[to]++;
        }

        Queue<Integer> Q = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();

        for (int j = 1; j <= N; j++) {
            if (inDegree[j] == 0) {
                Q.add(j);
            }
        }

        while (!Q.isEmpty()) {
            int cur = Q.poll();
            res.add(cur);

            for (int next : G.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    Q.add(next);
                }
            }
        }

        while (!res.isEmpty()) {
            bw.write(String.valueOf(res.poll()) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
