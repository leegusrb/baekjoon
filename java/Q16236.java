package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x, y, dist;

    public Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q16236 {
    static int N;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[][] G = new int[N][N];
        Pair cur = new Pair(0, 0);
        int curSize = 2;
        int eat = 0;
        int res = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                if (G[i][j] == 9) {
                    cur = new Pair(i, j);
                }
            }
        }

        while (true) {
            Queue<Pair> Q = new LinkedList<>();
            boolean[][] isVisit = new boolean[N][N];
            
            Q.add(new Pair(cur.x, cur.y, 0));
            isVisit[cur.x][cur.y] = true;
            G[cur.x][cur.y] = 0;

            int mnX = Integer.MAX_VALUE;
            int mnY = Integer.MAX_VALUE;
            int mnD = Integer.MAX_VALUE;

            while (!Q.isEmpty()) {
                Pair curFish = Q.poll();
                int x = curFish.x;
                int y = curFish.y;
                int dist = curFish.dist;

                if (mnD <= dist) break;
                
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (check(nx, ny) && !isVisit[nx][ny] && G[nx][ny] <= curSize) {
                        if (G[nx][ny] > 0 && G[nx][ny] < curSize) {
                            if (nx < mnX) {
                                mnX = nx;
                                mnY = ny;
                                mnD = dist + 1;
                            } else if (nx == mnX && ny < mnY) {
                                mnY = ny;
                                mnD = dist + 1;
                            }
                        }
                        Q.add(new Pair(nx, ny, dist + 1));
                        isVisit[nx][ny] = true;
                    }
                }
            }

            if (mnD == Integer.MAX_VALUE) break;

            cur = new Pair(mnX, mnY);
            eat++;
            res += mnD;
            G[mnX][mnY] = 0;

            if (eat == curSize) {
                eat = 0;
                curSize++;
            }
        }

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
