import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Q17070 {
    private static int N;
    private static int[][] G;
    private static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        G = new int[N + 2][N + 2];

        for (int i = 0; i < N + 2; i++) {
            G[0][i] = 1;
            G[i][0] = 1;
            G[N + 1][i] = 1;
            G[i][N + 1] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(new Pair(1, 1), new Pair(1, 2));

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean check(int x, int y) {
        if (G[x][y] == 0) return true;
        return false;
    }

    private static void DFS(Pair start, Pair end) {
        if (end.a == N && end.b == N) {
            res++;
            return;
        }

        if (check(end.a, end.b + 1) && check(end.a + 1, end.b + 1) && check(end.a + 1, end.b))
        DFS(end, new Pair(end.a + 1, end.b + 1));
        if (start.a == end.a) {
            if (check(end.a, end.b + 1))
                DFS(end, new Pair(end.a, end.b + 1));
        } else if (start.b == end.b) {
            if (check(end.a + 1, end.b))
                DFS(end, new Pair(end.a + 1, end.b));
        } else {
            if (check(end.a, end.b + 1))
                DFS(end, new Pair(end.a, end.b + 1));
            if (check(end.a + 1, end.b))
                DFS(end, new Pair(end.a + 1, end.b));
        }
    }
}
