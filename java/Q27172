import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q27172 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] cards = new boolean[1_000_001];
        ArrayList<Integer> nums = new ArrayList<>();
        int[] score = new int[1_000_001];
        int mx = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            cards[x] = true;
            nums.add(x);
            mx = Math.max(mx, x);
        }

        for (int i = 0; i < N; i++) {
            int num = nums.get(i);
            for (int j = num * 2; j <= mx; j += num) {
                if (cards[j]) {
                    score[num]++;
                    score[j]--;
                }
            }
        }

        for (int i = 0; i < N; i++)
            System.out.printf("%d ", score[nums.get(i)]);
    }
}