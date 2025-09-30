import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15681 {
    static ArrayList<Integer>[] G;
    static int[] subTreeSize;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        G = new ArrayList[N + 1];
        subTreeSize = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            G[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U =  Integer.parseInt(st.nextToken());
            int V =  Integer.parseInt(st.nextToken());

            G[U].add(V);
            G[V].add(U);
        }

        makeTree(R);

        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());

            System.out.println(subTreeSize[U]);
        }
    }

    private static void makeTree(int cur) {
        subTreeSize[cur] = 1;
        for (int child : G[cur]) {
            G[child].remove(Integer.valueOf(cur));
            makeTree(child);
            subTreeSize[cur] += subTreeSize[child];
        }
    }
}
