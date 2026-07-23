import java.util.*;
import java.io.*;

public class Main {
    static int[] distance;
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u  = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v,cost});
        }
        djk();

        for(int i=1;i<=N;i++){
            if(i==1)
                continue;
            if(distance[i] == Integer.MAX_VALUE)
                bw.write("-1\n");
            else
                bw.write(distance[i]+"\n");
        }

        bw.flush();
    }
    static void djk(){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1,0));
        distance[1] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost != distance[cur.v])
                continue;
            
            for(int[] next : graph.get(cur.v)){
                int d = cur.cost+next[1];

                if(d<distance[next[0]]){
                    distance[next[0]] = d;
                    pq.add(new Node(next[0], d));
                }
            }
        }
    }
}