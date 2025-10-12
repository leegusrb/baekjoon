import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1766 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        int[] inDegree = new int[N+1];

        for (int i = 0; i < N + 1; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            G.get(A).add(B);
            inDegree[B]++;
        }

        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                PQ.add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            int cur = PQ.poll();

            System.out.print(cur + " ");
            for (int to : G.get(cur)) {
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    PQ.add(to);
                }
            }
        }
    }
}