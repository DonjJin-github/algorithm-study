import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (pq1.isEmpty() || num <= pq1.peek()) {
                pq1.add(num);
            } else {
                pq2.add(num);
            }

            if (pq1.size() > pq2.size() + 1) {
                pq2.add(pq1.poll());
            } else if (pq2.size() > pq1.size()) {
                pq1.add(pq2.poll());
            }

            bw.write(pq1.peek() + "\n");
        }
        
        bw.flush();
    }
}
