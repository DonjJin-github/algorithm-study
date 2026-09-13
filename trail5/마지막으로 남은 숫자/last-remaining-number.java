import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            pq.add(num);
        }

        while(pq.size()>=2){
            int num1 = pq.poll();
            int num2 = pq.poll();

            if(num1-num2!=0){
                pq.add(num1-num2);
            }
        }
        if(pq.isEmpty())
            bw.write("-1\n");
        else
            bw.write(pq.poll()+"\n");

        bw.flush();
    }
}