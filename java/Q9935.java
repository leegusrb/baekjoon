package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Q9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bomb = br.readLine();
        
        Stack<Character> S = new Stack<>();

        for (char c : str.toCharArray()) {
            S.push(c);

            if (S.size() >= bomb.length()) {
                boolean isContain = true;
                for (int i = 0; i < bomb.length(); i++) {
                    if (S.get(S.size() - bomb.length() + i) != bomb.charAt(i)) {
                        isContain = false;
                        break;
                    }
                }
                if (isContain) {
                    for (int i = 0; i < bomb.length(); i++)
                        S.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : S)
            sb.append(c);

        bw.write(sb.length() == 0 ? "FRULA\n" : sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
