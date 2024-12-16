package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y, dist;
    boolean wall;

    public Node (int x, int y, int dist, boolean wall) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.wall = wall;
    }
}

public class Q2206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];
        boolean[][] isVisit1 = new boolean[N + 1][M + 1];
        boolean[][] isVisit2 = new boolean[N + 1][M + 1];
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = str.charAt(j - 1) - '0';
            }
        }

        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(1, 1, 1, false));
        isVisit1[1][1] = true;

        while(!Q.isEmpty()) {
            Node curNode = Q.poll();
            int x = curNode.x;
            int y = curNode.y;
            if (x == N && y == M) {
                res = Math.min(res, curNode.dist);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
                    if (!curNode.wall) {
                        if (!isVisit1[nx][ny]) {
                            Q.add(new Node(nx, ny, curNode.dist + 1, arr[nx][ny] == 0 ? false : true));
                            isVisit1[nx][ny] = true;
                        }
                    }
                    else {
                        if (!isVisit2[nx][ny] && arr[nx][ny] == 0) {
                            Q.add(new Node(nx, ny, curNode.dist + 1, true));
                            isVisit2[nx][ny] = true;
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(res != Integer.MAX_VALUE ? res : -1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
