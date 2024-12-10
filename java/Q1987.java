package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1987 {
    static int R, C;
    static int[][] G;
    static boolean[][] isVisit;
    static boolean[] isVisitAlp = new boolean[26];
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int res = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        G = new int[R][C];
        isVisit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                G[i][j] = tmp.charAt(j) - 'A';
            }
        }

        isVisit[0][0] = true;
        isVisitAlp[G[0][0]] = true;
        DFS(0, 0, 1);

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void DFS(int x, int y, int cnt) {
        res = Math.max(res, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!isVisit[nx][ny] && !isVisitAlp[G[nx][ny]]) {
                    isVisit[nx][ny] = true;
                    isVisitAlp[G[nx][ny]] = true;
                    DFS(nx, ny, cnt + 1);
                    isVisit[nx][ny] = false;
                    isVisitAlp[G[nx][ny]] = false;
                }
            }
        }
    }
}
