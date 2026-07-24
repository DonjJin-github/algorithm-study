import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static boolean[] visit;
    static class Node implements Comparable<Node>{
        int v;
        int cost;

        Node(int v, int cost){
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, cost});
            graph.get(v).add(new int[]{u, cost});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        int ans = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visit[cur.v])
                continue;
            visit[cur.v] = true;

            ans += cur.cost;
            for(int[] next : graph.get(cur.v)){
                if(visit[next[0]])
                    continue;
                
                pq.add(new Node(next[0], next[1]));
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}