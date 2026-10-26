import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 1000000000;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] distanceA;
    static int[] distanceB;
    static int[] distanceC;
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

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        distanceA = new int[N+1];
        distanceB = new int[N+1];
        distanceC = new int[N+1];
        for(int i=0;i<=N;i++){
            distanceA[i] = INF;
            distanceB[i] = INF;
            distanceC[i] = INF;
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, cost});
            graph.get(v).add(new int[]{u, cost});
        }
        dijk(A, distanceA);
        dijk(B, distanceB);
        dijk(C, distanceC);

        int ans = -1;
        for(int i=1;i<=N;i++){
            int a = distanceA[i];
            int b = distanceB[i];
            int c = distanceC[i];
            
            if(distanceA[i] == 0)
                a = INF;
            if(distanceB[i] == 0)
                b = INF;
            if(distanceC[i] == 0)
                c = INF;

            int temp = Math.min(a, Math.min(b, c));

            if(temp == INF)
                continue;
            
            ans = Math.max(ans, temp);
        }

        bw.write(ans+"\n");
        bw.flush();
    }
    static void dijk(int start, int[] distance){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost != distance[cur.v])
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