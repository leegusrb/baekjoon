package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q13172 {
    static long MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        long res = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());
            
            long mod = gcd(N, S);

            N /= mod;
            S /= mod;

            res += S * power(N, MOD - 2) % MOD;
            res %= MOD;
        }

        bw.write(String.valueOf(res) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static long gcd(long a, long b) {
        if (a <= b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        if (b == 0) return a;

        return gcd(b, a % b);
    }

    static long power(long a, long b) {
        if (b == 1) return a;

        long tmp = power(a, b / 2);

        if (b % 2 == 1)
            return tmp * tmp % MOD * a % MOD;

        return tmp * tmp % MOD;
    }
}
