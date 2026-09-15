import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();

            for(int i=0;i<M;i++){
                int num = Integer.parseInt(st.nextToken());

                if(max.isEmpty() || min.isEmpty()){
                    max.add(num);
                }
                else{
                    int temp = max.peek();
                    if(temp>=num){
                        max.add(num);
                    }
                    else{
                        min.add(num);
                    }
                }

                if(max.size()<min.size()){
                    while(!(max.size()-min.size()==1 || max.size()-min.size()==0)){
                        int temp = min.poll();
                        max.add(temp);
                    }
                }
                else{
                    while(!(max.size()-min.size()==1 || max.size()-min.size()==0)){
                        int temp = max.poll();
                        min.add(temp);
                    }
                }

                if(i%2==0)
                    bw.write(max.peek()+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}