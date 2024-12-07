import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair{
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Q15686 {
    static int N;
    static int M;
    static int[][] G;
    static int[][] dist;
    static boolean[] open;
    static ArrayList<Pair> ch;
    static ArrayList<Pair> house;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        G = new int[N][N];
        dist = new int[N][N];

        ch = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                if (G[i][j] == 1) house.add(new Pair(i, j));
                else if (G[i][j] == 2) ch.add(new Pair(i, j));
            }
        }

        open = new boolean[ch.size()];

        DFS(0, 0);

        bw.write(String.valueOf(ans) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int cur, int depth) {
        if (depth == M) {
            int res = 0;
            for (int i = 0; i < house.size(); i++) {
                int mn = Integer.MAX_VALUE;
                Pair h = house.get(i);
                for (int j = 0; j < ch.size(); j++) {
                    Pair c = ch.get(j);
                    if (open[j]) {
                        int d = Math.abs(h.a - c.a) + Math.abs(h.b - c.b);
                        mn = Math.min(mn, d);
                    }
                }
                res += mn;
            }
            ans = Math.min(ans, res);
            return;
        }

        for (int i = cur; i < ch.size(); i++) {
            open[i] = true;
            DFS(i + 1, depth + 1);
            open[i] = false;
        }
    }
}
