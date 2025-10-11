import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16724 {
    static char[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) dfs(i, j);
            }
        }

        System.out.println(res);
    }

    private static void dfs(int x, int y) {
        int next = getNextIdx(x, y);
        int nx = x + dx[next];
        int ny = y + dy[next];

        visited[x][y] = 1;

        if (visited[nx][ny] == 1) res++;
        if (visited[nx][ny] == 0) dfs(nx, ny);
        visited[x][y] = 2;
    }

    private static int getNextIdx(int x, int y) {
        char dir = map[x][y];

        if (dir == 'U') return 0;
        if (dir == 'D') return 1;
        if (dir == 'L') return 2;
        return 3;
    }
}
