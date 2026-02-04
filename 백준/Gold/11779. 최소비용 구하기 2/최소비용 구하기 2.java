import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE/2;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static long[] distance;
    static int[] route;

    static class Node implements Comparable<Node> {
        int v;
        long cost;

        public Node(int v, long cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node newNode) {
            return Long.compare(cost, newNode.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        distance = new long[V + 1];
        route = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            distance[i] = INF;
            route[i] = -1;
        }
        StringTokenizer st = new StringTokenizer("");

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[] { v, cost });
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost != distance[cur.v])
                continue;

            for (int[] node : graph.get(cur.v)) {
                long d = distance[cur.v] + node[1];
                if (distance[node[0]] > d) {
                    distance[node[0]] = d;
                    pq.add(new Node(node[0], d));
                    route[node[0]] = cur.v;
                }
            }
        }

        bw.write(distance[end] + "\n");

        List<Integer> path = new ArrayList<>();
        int cur = end;

        while (cur != start) {
            path.add(cur);
            cur = route[cur];
        }
        path.add(start);
        Collections.reverse(path);

        bw.write(path.size() + "\n");
        for (int x : path) {
            bw.write(x + " ");
        }
        bw.write("\n");
        bw.flush();

    }
}
