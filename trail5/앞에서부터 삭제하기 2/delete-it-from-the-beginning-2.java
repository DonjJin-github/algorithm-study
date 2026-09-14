import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int idx;
        int num;;

        Node(int idx, int num){
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Node newNode){
            if(num==newNode.num)
                return Integer.compare(idx, newNode.idx);
            return Integer.compare(num, newNode.num);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Node> set = new TreeSet<>();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            set.add(new Node(i, num));
            sum+=num;
        }

        double ans = 0;
        for(int i=0;i<N-2;i++){
            Node cur = new Node(i, arr[i]);
            sum -= cur.num;
            set.remove(cur);

            Node temp = set.first();
            sum -= temp.num;
            ans = Math.max(ans, (double)sum/(set.size()-1));
            sum += temp.num;
        }

        bw.write(String.format("%.2f", ans));
        bw.flush();
    }
}