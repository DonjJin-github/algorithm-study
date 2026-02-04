import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 3000000;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] distance;

    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node newNode) {
            return Integer.compare(cost, newNode.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        distance = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            distance[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[] { v, cost });
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost != distance[cur.v])
                continue;

            for (int[] node : graph.get(cur.v)) {
                int d = distance[cur.v] + node[1];
                if (distance[node[0]] > d) {
                    distance[node[0]] = d;
                    pq.add(new Node(node[0], d));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF)
                bw.write("INF\n");
            else
                bw.write(distance[i] + "\n");
        }
        bw.flush();

    }
}
