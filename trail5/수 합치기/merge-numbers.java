import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        while(pq.size()>1){
            int num1 = pq.poll();
            int num2 = pq.poll();
            ans += num1+num2;
            pq.add(num1+num2);
            
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}