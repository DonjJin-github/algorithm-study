import java.io.*;
import java.util.*;

public class Main {
    static class node implements Comparable<node> {
        int x;

        node(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(node newNode) {
            if (Math.abs(this.x) != Math.abs(newNode.x))
                return Integer.compare(Math.abs(this.x), Math.abs(newNode.x));

            return Integer.compare(this.x, newNode.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<node> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp!=0){
                pq.add(new node(temp));
            }
            else{
                if(pq.isEmpty())
                    bw.write("0\n");
                else{
                    int least = pq.poll().x;
                    bw.write(least+"\n");
                }
            }
        }
        bw.flush();
    }
}
