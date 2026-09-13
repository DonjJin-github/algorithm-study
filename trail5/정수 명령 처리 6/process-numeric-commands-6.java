import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int num;

        Node(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Node newNode){
            return Integer.compare(newNode.num, num);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String op = st.nextToken();

            if(op.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                pq.add(new Node(num));
            }
            else if(op.equals("pop")){
                Node cur = pq.poll();
                bw.write(cur.num+"\n");
            }
            else if(op.equals("size")){
                bw.write(pq.size()+"\n");
            }
            else if(op.equals("empty")){
                if(pq.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }
            else{
                Node cur = pq.peek();
                bw.write(cur.num+"\n");
            }
        }
        bw.flush();
    }
}