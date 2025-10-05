import java.io.BufferedReader;
import java.io.InputStreamReader;
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

public class Q1647 {
    static int N;
    static ArrayList<ArrayList<Node>> G;
    static int res = 0;
    static int mx = 0;

    static void prim(int v) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isVisit = new boolean[N + 1];

        pq.add(new Node(v, 0));

        while (!pq.isEmpty()) {
            Node curNode =  pq.poll();
            int cur = curNode.to;
            int weight =  curNode.weight;

            if (isVisit[cur]) continue;

            isVisit[cur] = true;
            res += weight;
            mx = Math.max(mx, weight);

            for (Node node : G.get(cur)) {
                if (!isVisit[node.to]) {
                    pq.add(new Node(node.to, node.weight));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        G = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            G.get(A).add(new Node(B, C));
            G.get(B).add(new Node(A, C));
        }

        prim(1);

        System.out.println(res - mx);
    }
}