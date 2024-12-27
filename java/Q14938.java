package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int to, weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

}

public class Q14938 {
    static int n;
    static int m;
    static int[] item;
    static ArrayList<ArrayList<Node>> G;
    static boolean[] isVisit;
    static int[] dist;
    static int INF = 100 * 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        item = new int[n + 1];
        G = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            G.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            G.get(from).add(new Node(to, weight));
            G.get(to).add(new Node(from, weight));
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[j] <= m)
                    cnt += item[j];
            }
            res = Math.max(res, cnt);
        }

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        isVisit = new boolean[n + 1];
        dist = new int[n + 1];
        PriorityQueue<Node> Q = new PriorityQueue<>();

        Arrays.fill(dist, INF);
        dist[start] = 0;
        Q.add(new Node(start, 0));

        while (!Q.isEmpty()) {
            Node curNode = Q.poll();
            int cur = curNode.to;
            isVisit[cur] = true;

            for (Node node : G.get(cur)) {
                int to = node.to;
                int weight = node.weight;

                if (!isVisit[to] && dist[to] > dist[cur] + weight) {
                    dist[to] = dist[cur] + weight;
                    Q.add(new Node(to, dist[to]));
                }
            }
        }
    }
}
