import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 100000000;
    static ArrayList<ArrayList<int[]>> graph1 = new ArrayList<>();
    static ArrayList<ArrayList<int[]>> graph2 = new ArrayList<>();
    static int[] distance1;
    static int[] distance2;
    static int X;
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance1 = new int[N+1];
        distance2 = new int[N+1];
        for(int i=0;i<=N;i++){
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
            distance1[i] = INF;
            distance2[i] = INF;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph1.get(u).add(new int[]{v, cost});
            graph2.get(v).add(new int[]{u, cost});
        }

        dijk(distance1, graph1);
        dijk(distance2, graph2);

        int ans = 0;
        for(int i=1;i<=N;i++){
            int temp = 0;
            if(distance1[i]!=INF && distance2[i]!=INF)
                temp += distance1[i] + distance2[i];
            
            ans = Math.max(ans, temp);
        }

        bw.write(ans+"\n");
        bw.flush();
    }
    static void dijk(int[] distance, ArrayList<ArrayList<int[]>> graph){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(X,0));
        distance[X] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(distance[cur.v] != cur.cost)
                continue;
            
            for(int[] next : graph.get(cur.v)){
                int d = next[1] + cur.cost;
                if(d<distance[next[0]]){
                    distance[next[0]] = d;
                    pq.add(new Node(next[0], d));
                }
            }
        }
    }
}