import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node newNode){
            if(x == newNode.x){
                return Integer.compare(y, newNode.y);
            }
            return Integer.compare(x, newNode.x);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Node> set = new TreeSet<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            set.add(new Node(x, y));
        }

        for(int i=0;i<M;i++){
            int num = Integer.parseInt(br.readLine());

            Node find = set.ceiling(new Node(num, 0));

            if(find==null){
                bw.write("-1 -1\n");
            }
            else{
                bw.write(find.x+" "+find.y+"\n");
                set.remove(find);
            }
        }

        bw.flush();
    }
}