import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            pq.add(num);

            if(pq.size()<3){
                bw.write("-1\n");
            }else{
                int n1 = pq.poll();
                int n2 = pq.poll();

                bw.write((long)n1*n2*pq.peek()+"\n");

                pq.add(n1);
                pq.add(n2);
            }
        }
        bw.flush();
    }
}