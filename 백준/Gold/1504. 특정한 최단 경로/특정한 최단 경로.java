import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 200000000;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] distance;
    static int N, E;

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

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[] { v, cost });
            graph.get(v).add(new int[] { u, cost });
        }

        st = new StringTokenizer(br.readLine());
        int must1 = Integer.parseInt(st.nextToken());
        int must2 = Integer.parseInt(st.nextToken());

        int ans = Math.min(dj(must1,must2), dj(must2,must1));
        
        bw.write(ans + "\n");
        bw.flush();
    }

    static int dj(int must1, int must2) {
        int ans = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(distance, INF);

        distance[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost != distance[node.v])
                continue;

            for (int[] next : graph.get(node.v)) {
                int d = next[1] + distance[node.v];

                if (distance[next[0]] > d) {
                    distance[next[0]] = d;
                    pq.add(new Node(next[0], d));
                }
            }
        }

        if (distance[must1] == INF) {
            return -1;
        }
        ans += distance[must1];

        pq = new PriorityQueue<>();
        Arrays.fill(distance, INF);

        distance[must1] = 0;
        pq.add(new Node(must1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost != distance[node.v])
                continue;

            for (int[] next : graph.get(node.v)) {
                int d = next[1] + distance[node.v];

                if (distance[next[0]] > d) {
                    distance[next[0]] = d;
                    pq.add(new Node(next[0], d));
                }
            }
        }

        if (distance[must2] == INF) {
            return -1;
        }
        ans += distance[must2];

        pq = new PriorityQueue<>();
        Arrays.fill(distance, INF);

        distance[must2] = 0;
        pq.add(new Node(must2, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost != distance[node.v])
                continue;

            for (int[] next : graph.get(node.v)) {
                int d = next[1] + distance[node.v];

                if (distance[next[0]] > d) {
                    distance[next[0]] = d;
                    pq.add(new Node(next[0], d));
                }
            }
        }

        if (distance[N] == INF) {
            return -1;
        }
        ans += distance[N];

        return ans;
    }
}
