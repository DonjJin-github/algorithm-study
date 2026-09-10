import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int start;
        int end;
        int length;

        Node(int start, int end, int length){
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Node> set = new TreeSet<>((a,b)->{
            return Integer.compare(a.start, b.start);
        });
        TreeSet<Node> ans = new TreeSet<>((a,b)->{
            if(a.length==b.length)
                return Integer.compare(a.start, b.start);
            return Integer.compare(a.length, b.length);
        });

        st = new StringTokenizer(br.readLine());
        Node node = new Node(0, N, N+1);
        set.add(node);
        ans.add(node);
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());

            Node cur = set.floor(new Node(num, 0, 0));
            set.remove(cur);
            ans.remove(cur);
            
            Node node1 = new Node(cur.start, num-1, num-cur.start);
            Node node2 = new Node(num+1, cur.end, cur.end-num);
            set.add(node1);
            set.add(node2);
            ans.add(node1);
            ans.add(node2);

            bw.write(ans.last().length+"\n");
        }
        bw.flush();
    }
}