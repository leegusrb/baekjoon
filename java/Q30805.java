package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q30805 {
    static ArrayList<Integer> A = new ArrayList<>();
    static ArrayList<Integer> B = new ArrayList<>();
    static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        
        sol(0, 0);

        bw.write(String.valueOf(res.size()) + "\n");
        for (int i : res) {
            bw.write(String.valueOf(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void sol(int idx1, int idx2) {
        if (A.size() <= idx1 || B.size() <= idx2) return;
        int mx1 = idx1, mx2 = idx2;

        for (int i = idx1; i < A.size(); i++) {
            if (A.get(i) > A.get(mx1)) {
                mx1 = i;
            }
        }

        for (int i = idx2; i < B.size(); i++) {
            if (B.get(i) > B.get(mx2)) {
                mx2 = i;
            }
        }

        if (A.get(mx1) > B.get(mx2)) {
            A.remove(mx1);
            sol(idx1, idx2);
        } else if (A.get(mx1) < B.get(mx2)) {
            B.remove(mx2);
            sol(idx1, idx2);
        } else {
            res.add(A.get(mx1));
            A.remove(mx1);
            B.remove(mx2);
            sol(mx1, mx2);
        }
    }
}
