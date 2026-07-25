import java.util.*;
import java.io.*;

public class Main {
    static int[] p;
    static class Node implements Comparable<Node>{
        int u;
        int v;
        int cost;

        Node(int u, int v, int cost){
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node newNode){
            return Integer.compare(cost, newNode.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N+1];
        Arrays.fill(p,-1);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Node(u, v, cost));
        }

        int ans = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(find(cur.u) == find(cur.v))
                continue;
            uni(cur.u, cur.v);
            ans+=cur.cost;
        }
        bw.write(ans+"\n");
        bw.flush();
    }
    static int find(int x){
        if(p[x]<0)
            return x;
        
        return p[x] = find(p[x]);
    }
    static boolean uni(int u, int v){
        u = find(u);
        v = find(v);
        
        if(u==v)
            return false;
        
        p[v] = u;
        return true;
    }
}