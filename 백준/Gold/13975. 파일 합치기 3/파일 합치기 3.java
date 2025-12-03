import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long ans = 0;
            while (!pq.isEmpty()) {
                if (pq.size() > 2) {
                    long temp = pq.poll() + pq.poll();
                    ans += temp;
                    pq.add(temp);
                }
                else if(pq.size()==2){
                    ans += pq.poll()+pq.poll();
                    break;
                }
                else{
                    ans += pq.poll();
                    break;
                }
            }
            bw.write(ans+"\n");
        }
        bw.flush();
    }
}
