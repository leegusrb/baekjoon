package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    public Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q2683 {
    static int N, M;
    static int[][] G;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

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

        int res = 0;
        while (!check()) {
            findOut();
            findDisappear();
            toAir();
            res++;
        }

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void toAir() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (G[i][j] == 2)
                    G[i][j] = 0;
            }
        }
    }

    static void findDisappear() {
        ArrayList<Pair> find = new ArrayList<>();
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (G[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (G[nx][ny] == 2) {
                            cnt++;
                        }
                    }
                    if (cnt >= 2) {
                        find.add(new Pair(i, j));
                    }
                }
            }
        }

        for (Pair p : find) {
            G[p.x][p.y] = 0;
        }
    }

    static void findOut() {
        Stack<Pair> S = new Stack<>();
        S.add(new Pair(0, 0));
        G[0][0] = 2;

        while (!S.isEmpty()) {
            Pair cur = S.pop();
            int x = cur.x;
            int y = cur.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && G[nx][ny] == 0) {
                    S.add(new Pair(nx, ny));
                    G[nx][ny] = 2;
                }
            }
        }
    }

    static boolean check() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (G[i][j] == 1)
                    cnt++;
            }
        }

        return cnt == 0;
    }
}
