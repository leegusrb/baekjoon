package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7453 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] A = new int[n * n];
        int[] B = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[idx] = arr[0][i] + arr[1][j];
                B[idx++] = arr[2][i] + arr[3][j];
            }
        }

        Arrays.sort(A);
        Arrays.sort(B);

        long res = 0;
        int l = 0, r = n * n - 1;
        while (l < n * n && r >= 0) {
            int s = A[l] + B[r];

            if (s == 0) {
                long lcnt = 1, rcnt = 1;
                while (l + 1 < n * n && A[l] == A[l + 1]) {
                    l++;
                    lcnt++;
                }
                while (r - 1 >= 0 && B[r] == B[r - 1]) {
                    r--;
                    rcnt++;
                }
                res += lcnt * rcnt;
                l++;
                r--;
            } else if (s < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(res);

        br.close();
    }
}
