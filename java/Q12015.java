package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] res = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        res[0] = A[0];
        int len = 1;

        for (int i = 1; i < N; i++) {
            int cur = A[i];

            if (cur > res[len - 1]) {
                res[len++] = cur;
            } else {
                int l = 0, r = len;

                while (l < r) {
                    int mid = (l + r) / 2;

                    if (cur > res[mid]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }

                res[l] = cur;
            }
        }

        System.out.println(len);

        br.close();
    }
}
