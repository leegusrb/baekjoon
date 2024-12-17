package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Q1167 {
    static int V;
    static ArrayList<ArrayList<Node>> G = new ArrayList<>();
    static boolean[] isVisit;
    static int mx = 0;
    static int mxNode = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());
        isVisit = new boolean[V + 1];

        for (int i = 0; i <= V; i++)
            G.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());

                G.get(from).add(new Node(to, weight));
            }
        }

        DFS(1, 0);

        Arrays.fill(isVisit, false);
        mx = 0;

        DFS(mxNode, 0);

        bw.write(String.valueOf(mx) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void DFS(int cur, int len) {
        if (mx < len) {
            mx = len;
            mxNode = cur;
        }
        isVisit[cur] = true;
        
        for (Node node : G.get(cur)) {
            int next = node.to;
            if (!isVisit[next]) {
                DFS(next, len + node.weight);
            }
        }
    }
}
