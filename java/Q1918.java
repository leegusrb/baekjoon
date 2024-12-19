package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Q1918 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Stack<Character> S = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                bw.write(c);
            } else if (c == '(') {
                S.add('(');
            } else if (c == ')') {
                while (!S.empty()) {
                    char tmp = S.pop();
                    if (tmp == '(') break;
                    bw.write(tmp);
                }
            } else if (c == '+' || c == '-') {
                while (!S.empty()) {
                    int tmp = S.peek();
                    if (tmp == '(') break;
                    bw.write(S.pop());
                }
                S.add(c);
            } else if (c == '*' || c == '/') {
                while (!S.empty()) {
                    int tmp = S.peek();
                    if (tmp == '(' || tmp == '+' || tmp == '-') break;
                    bw.write(S.pop());
                }
                S.add(c);
            }
        }

        while (!S.empty())
            bw.write(S.pop());

        bw.flush();
        bw.close();
        br.close();
    }
}
