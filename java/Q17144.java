package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q17144 {
    static int R, C, T, A;
    static int[][] G, N;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                if (G[i][j] == -1) {
                    A = i;
                }
            }
        }

        for (int idx = 0; idx < T; idx++) {
            N = new int[R][C];
            for (int x = 0; x < R; x++) {
                for (int y = 0; y < C; y++) {
                    if (G[x][y] <= 0) continue;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && G[nx][ny] != -1) {
                            N[nx][ny] += G[x][y] / 5;
                            N[x][y] -= G[x][y] / 5;
                        }
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (G[i][j] != -1)
                        G[i][j] += N[i][j];
                }
            }

            for (int i = A - 2; i >= 1; i--)
                G[i][0] = G[i - 1][0];
            for (int i = 0; i <= C - 2; i++)
                G[0][i] = G[0][i + 1];
            for (int i = 0; i <= A - 2; i++)
                G[i][C - 1] = G[i + 1][C - 1];
            for (int i = C - 1; i >= 2; i--)
                G[A - 1][i] = G[A - 1][i - 1];
            G[A - 1][1] = 0;

            for (int i = A + 1; i <= R - 2; i++)
                G[i][0] = G[i + 1][0];
            for (int i = 0; i <= C - 2; i++)
                G[R - 1][i] = G[R - 1][i + 1];
            for (int i = R - 1; i >= A + 1; i--)
                G[i][C - 1] = G[i - 1][C - 1];
            for (int i = C - 1; i >= 2; i--)
                G[A][i] = G[A][i - 1];
            G[A][1] = 0;
        }

        int res = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res += G[i][j];
            }
        }

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
