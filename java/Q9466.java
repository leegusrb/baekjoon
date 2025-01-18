package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q9466 {
    static int[] to;
    static boolean[] isVisit;
    static boolean[] check;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            to = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                to[i] = Integer.parseInt(st.nextToken());
            }

            isVisit = new boolean[n + 1];
            check = new boolean[n + 1];
            res = n;

            for (int i = 1; i <= n; i++) {
                dfs(i);
            }

            sb.append(String.valueOf(res));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int cur) {
        if (isVisit[cur]) return;

        isVisit[cur] = true;
        int next = to[cur];

        dfs(next);
        
        if (!check[next]) {
            res--;
            for (int i = next; i != cur; i = to[i]) {
                check[i] = true;
                res--;
            }
        }

        check[cur] = true;
    }
}
