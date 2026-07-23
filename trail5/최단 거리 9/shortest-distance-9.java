import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 100000000;
    static int[] distance;
    static int[] parent;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
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
        
        int N  = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        parent = new int[N+1];
        for(int i=0;i<=N;i++){
            distance[i] = INF;
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u  = Integer.parseInt(st.nextToken());
            int v  = Integer.parseInt(st.nextToken());
            int cost  = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v,cost});
            graph.get(v).add(new int[]{u,cost});
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        djk(start);

        ArrayList<Integer> list = new ArrayList<>();
        int cur = end;
        while(cur != start){
            list.add(cur);
            cur = parent[cur];
        }
        list.add(start);
        Collections.reverse(list);

        bw.write(distance[end]+"\n");
        for(int print : list)
            bw.write(print+" ");
        bw.flush();

    }
    static void djk(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost != distance[cur.v])
                continue;
            
            for(int[] next : graph.get(cur.v)){
                int d = cur.cost + next[1];

                if(d<distance[next[0]]){
                    pq.add(new Node(next[0], d));
                    distance[next[0]] = d;
                    parent[next[0]] = cur.v;
                }
            }
        }
    }
}