import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            long num = Long.parseLong(br.readLine());

            if(num==0){
                if(pq.isEmpty()){
                    bw.write("0\n");
                }
                else{
                    bw.write(pq.poll()+"\n");
                }
            }else{
                pq.add(num);
            }
        }
        bw.flush();
    }
}