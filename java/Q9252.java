package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Q9252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] arr = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        Stack<Character> S = new Stack<>();
        int i = l1, j = l2;
        while (arr[i][j] != 0) {
            if (arr[i - 1][j] == arr[i][j - 1] && arr[i][j] != arr[i - 1][j - 1]) {
                S.add(s1.charAt(i - 1));
                i--;
                j--;
            } else if (arr[i - 1][j] > arr[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        bw.write(String.valueOf(arr[l1][l2]) + "\n");
        while (!S.isEmpty()) {
            char c = S.pop();
            bw.write(c);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
