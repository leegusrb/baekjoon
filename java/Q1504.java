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
    int to;
    int weight;

    Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Q1504 {
    static int N, E;
    static ArrayList<ArrayList<Node>> G = new ArrayList<>();
    static boolean[] isVisit;
    static int[] dist;
    static int INF = 200000 * 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        isVisit = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            G.get(v1).add(new Node(v2, weight));
            G.get(v2).add(new Node(v1, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        int res;
        if (res1 >= INF && res2 >= INF) {
            res = -1;
        } else {
            res = Math.min(res1, res2);
        }

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(isVisit, false);
        Arrays.fill(dist, INF);

        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(start, 0));
        dist[start] = 0;

        while (!PQ.isEmpty()) {
            Node curNode = PQ.poll();
            int cur = curNode.to;

            if (!isVisit[cur]) {
                isVisit[cur] = true;
                
                for (Node node : G.get(cur)) {
                    if (!isVisit[node.to] && dist[node.to] > dist[cur] + node.weight) {
                        dist[node.to] = dist[cur] + node.weight;
                        PQ.add(new Node(node.to, dist[node.to]));                    
                    }
                }
            }
        }

        return dist[end];
    }
}
