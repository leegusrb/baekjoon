package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2239 {
    static int[][] A;
    static boolean[][] X, Y, S;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A = new int[9][9];
        X = new boolean[10][10];
        Y = new boolean[10][10];
        S = new boolean[10][10];

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                A[i][j] = s.charAt(j) - '0';
                if (A[i][j] != 0) {
                    X[i][A[i][j]] = true;
                    Y[j][A[i][j]] = true;
                    S[square(i, j)][A[i][j]] = true;
                }
            }
        }

        sudoku(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(String.valueOf(A[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int square(int x, int y) {
        return x / 3 * 3 + y / 3;
    }

    static boolean sudoku(int idx) {
        if (idx == 81) return true;

        int x = idx / 9;
        int y = idx % 9;

        if (A[x][y] != 0) return sudoku(idx + 1);

        for (int i = 1; i <= 9; i++) {
            if (!X[x][i] && !Y[y][i] && !S[square(x, y)][i]) {
                X[x][i] = Y[y][i] = S[square(x, y)][i] = true;
                A[x][y] = i;
                if (sudoku(idx + 1)) return true;
                X[x][i] = Y[y][i] = S[square(x, y)][i] = false;
                A[x][y] = 0;
            }
        }

        return false;
    }
}
