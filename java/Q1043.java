package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1043 {
    private static int N;
    private static int M;
    private static int knowN;
    private static ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
    private static int res = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        knowN = Integer.parseInt(st.nextToken());
        int[] torf = new int[N + 1];
        for (int i = 0; i < knowN; i++) {
            int n = Integer.parseInt(st.nextToken());
            torf[n] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            ArrayList<Integer> party = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        DFS(0, torf, 0);

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void DFS(int depth, int[] torf, int fal) {
        if (depth == M) {
            res = Math.max(res, fal);
            return;
        }

        int[] cnt = new int[3];
        for (int n : parties.get(depth)) {
            cnt[torf[n]]++;
        }
        
        if (cnt[1] == 0) {
            int[] narr = torf.clone();
            for (int n : parties.get(depth)) {
                narr[n] = 2;
            }
            DFS(depth + 1, narr, fal + 1);
        }
        if (cnt[2] == 0) {
            int[] narr = torf.clone();
            for (int n : parties.get(depth)) {
                narr[n] = 1;
            }
            DFS(depth + 1, narr, fal);
        }
    }
}
