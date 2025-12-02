import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            pq.add(temp);
        }

        int ans = 0;

        if(N==1){
            bw.write("0\n");
            bw.flush();
            return;
        }
        while (!pq.isEmpty()) {
            if (pq.size() > 2) {
                int temp = pq.poll() + pq.poll();
                ans += temp;
                pq.add(temp);
            } else if (pq.size() == 2) {
                ans += pq.poll() + pq.poll();
                bw.write(ans + "\n");
                bw.flush();
                return;
            } else {
                ans += pq.poll();
                bw.write(ans + "\n");
                bw.flush();
                return;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
