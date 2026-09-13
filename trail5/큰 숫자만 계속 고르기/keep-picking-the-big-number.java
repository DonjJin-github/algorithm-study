import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<M;i++){
            int num = pq.poll()-1;
            pq.add(num);
        }

        bw.write(pq.peek()+"\n");
        bw.flush();
    }
}