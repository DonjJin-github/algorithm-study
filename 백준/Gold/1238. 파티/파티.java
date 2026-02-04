import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000000;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] toX;
    static int[] toHome;

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        toHome = new int[N + 1];
        toX = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            toHome[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[] { v, cost });
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        toHome[X] = 0;
        pq.add(new Node(X, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost != toHome[node.v])
                continue;

            for (int next[] : graph.get(node.v)) {
                int d = next[1] + toHome[node.v];

                if (toHome[next[0]] > d) {
                    toHome[next[0]] = d;
                    pq.add(new Node(next[0], d));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            pq = new PriorityQueue<>();
            Arrays.fill(toX, INF);
            toX[i] = 0;
            pq.add(new Node(i, 0));

            while (!pq.isEmpty()) {
                Node node = pq.poll();

                if (node.cost != toX[node.v])
                    continue;

                for (int next[] : graph.get(node.v)) {
                    int d = next[1] + toX[node.v];

                    if (toX[next[0]] > d) {
                        toX[next[0]] = d;
                        pq.add(new Node(next[0], d));
                    }
                }
            }
            int temp = toHome[i] + toX[X];
            if (temp >= INF)
                temp = 0;

            ans = Math.max(ans, temp);
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}
