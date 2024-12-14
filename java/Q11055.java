package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11055 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        int[] mx = new int[N];
        int res = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());

            mx[i] = ar[i];
            for (int j = 0; j < i; j++) {
                if (ar[i] > ar[j]) {
                    mx[i] = Math.max(mx[i], mx[j] + ar[i]);
                }
            }
            
            res = Math.max(res, mx[i]);
        }

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
