package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2448 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] star = {"  *  ".toCharArray(), " * * ".toCharArray(), "*****".toCharArray()};
    static char[][] stars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stars = new char[N][N * 2];

        makeStar(N / 3 / 2, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2; j++) {
                bw.write(stars[i][j] == '*' ? "*" : " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void makeStar(int n, int y, int x) {
        if (n == 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    stars[y + i][x + j] = star[i][j];
                }
            }
            return;
        }
        makeStar(n / 2, y, x + n * 3);
        makeStar(n / 2, y + n * 3, x);
        makeStar(n / 2, y + n * 3, x + n * 3 * 2);
    }
}
