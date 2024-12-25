package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Q14502 {
    static int N;
    static int M;
    static int[][] G;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void combination(int depth, int idx) {
        if (depth == 3) {
            int[][] V = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    V[i][j] = G[i][j];
                }
            }

            Stack<Pair> S = new Stack<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (V[i][j] == 2) {
                        S.push(new Pair(i, j));
                    }
                }
            }

            while (!S.isEmpty()) {
                Pair cur = S.pop();
                int x = cur.a;
                int y = cur.b;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && V[nx][ny] == 0) {
                        V[nx][ny] = 2;
                        S.push(new Pair(nx, ny));
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (V[i][j] == 0)
                        cnt++;
                }
            }

            res = Math.max(res, cnt);

            return;
        }
        if (idx >= N * M) return;

        int x = idx / M;
        int y = idx % M;
        if (G[x][y] == 0) {
            G[x][y] = 1;
            combination(depth + 1, idx + 1);
            G[x][y] = 0;
        }

        combination(depth, idx + 1);
    }
}
