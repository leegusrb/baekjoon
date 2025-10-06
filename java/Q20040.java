import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20040 {
    static int[] group;

    static int findGroup(int u) {
        if (group[u] == u) return u;
        return group[u] = findGroup(group[u]);
    }

    static boolean checkCycle(int u, int v) {
        int ug =  findGroup(u);
        int vg =  findGroup(v);

        if (ug == vg) return true;

        group[ug] = vg;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());
        int res = 0;

        group = new int[n + 1];
        for (int i = 1; i <= n; i++)
            group[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u =  Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (checkCycle(u, v)) {
                res = i + 1;
                break;
            }
        }

        System.out.println(res);
    }
}