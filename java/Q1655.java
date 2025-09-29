import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> - Integer.compare(o1, o2));

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (i == 0 || i == 1)
                maxHeap.add(n);
            else {
                if (minHeap.peek() > n) {
                    maxHeap.add(n);
                } else {
                    minHeap.add(n);
                }
            }

            if (minHeap.size() + 1 < maxHeap.size()) {
                minHeap.add(maxHeap.remove());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.remove());
            }

            System.out.println(maxHeap.peek());
        }
    }
}
