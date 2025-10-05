import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q17404 {
    static Pair getPair(int a) {
        return new Pair((a + 1) % 3, (a + 2) % 3);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int mn = Integer.MAX_VALUE;
        for (int first = 0; first < 3; first++) {
            int[][] dp = new int[N][3];
            for (int i = 0; i < N; i++)
                dp[i] = rgb[i].clone();

            Pair p =  getPair(first);
            dp[0][p.x] = 1001;
            dp[0][p.y] = 1001;

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    Pair p2 = getPair(j);
                    dp[i][j] += Math.min(dp[i - 1][p2.x], dp[i - 1][p2.y]);
                }
            }

            mn = Math.min(mn, Math.min(dp[N - 1][p.x], dp[N - 1][p.y]));
        }

        System.out.println(mn);
    }
}