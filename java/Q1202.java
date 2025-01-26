package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewellery implements Comparable<Jewellery> {
    int M, V;

    public Jewellery(int M, int V) {
        this.M = M;
        this.V = V;
    }

    @Override
    public int compareTo(Jewellery o) {
        if (this.M == o.M)
            return o.V - this.V;
        return this.M - o.M;
    }
}

public class Q1202 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewellery[] Jewellerys = new Jewellery[N];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            Jewellerys[i] = new Jewellery(M, V);
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(Jewellerys);
        Arrays.sort(bags);
        
        int j = 0;
        long res = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int bag : bags) {
            while (j < N && bag >= Jewellerys[j].M) {
                PQ.add(Jewellerys[j++].V);
            }

            if (!PQ.isEmpty()) {
                res += PQ.poll();
            }
        }

        System.out.println(res);

        br.close();
    }
}
