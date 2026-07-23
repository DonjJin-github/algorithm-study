import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 1000000000;
    static int[] distance;
    static int[] distanceEnd;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static class Node implements Comparable<Node>{
        int v;
        int cost;

        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(cost, n.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        distanceEnd = new int[N+1];
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
            distance[i] = INF;
            distanceEnd[i] = INF;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v,cost});
            graph.get(v).add(new int[]{u,cost});
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        djk(start, distance);
        djk(end, distanceEnd);

        bw.write(distance[end]+"\n");

        int cur = start;
        while(cur != end){
            bw.write(cur+" ");
            int nextVertex = INF;

            for(int[] next : graph.get(cur)){
                int nextNode = next[0];
                int cost = next[1];

                if(distance[cur] + cost + distanceEnd[nextNode] == distance[end]){
                    nextVertex = Math.min(nextVertex, nextNode);
                }
            }
            cur = nextVertex;
        }

        bw.write(end+" ");
        bw.flush();
    }

    static void djk(int start, int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start,0));


        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost != dist[cur.v])
                continue;

            for(int[] next : graph.get(cur.v)){
                int d = next[1] + cur.cost;

                if(d < dist[next[0]]){
                    dist[next[0]] = d;
                    pq.add(new Node(next[0],d));
                }
            }
        }
    }
}