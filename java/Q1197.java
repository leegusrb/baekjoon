package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int to, weight;

    public Node (int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Q1197 {
    static int V, E;
    static ArrayList<ArrayList<Node>> G;
    static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        G = new ArrayList<>();

        for (int i = 0; i < V + 1; i++) {
            G.add(new ArrayList<>());
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            G.get(from).add(new Node(to, weight));
            G.get(to).add(new Node(from, weight));
        }

        Prim(1);

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void Prim(int v) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        boolean[] isVisit = new boolean[V + 1];

        PQ.add(new Node(v, 0));
        
        while (!PQ.isEmpty()) {
            Node curNode = PQ.poll();
            int cur = curNode.to;
            int weight = curNode.weight;

            if (isVisit[cur]) continue;

            isVisit[cur] = true;
            res += weight;

            for (Node node : G.get(cur)) {
                if (!isVisit[node.to]) {
                    PQ.add(new Node(node.to, node.weight));
                }
            }
        }
    }
}
