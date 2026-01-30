import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static boolean[] check;

    static class Node implements Comparable<Node> {
        int u;
        int v;
        int cost;

        public Node(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node newNode) {
            return Integer.compare(this.cost, newNode.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int ans = 0;
        int cv = 0;

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        check = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[] { v, cost });
            graph.get(v).add(new int[] { u, cost });
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int[] next : graph.get(1)) {
            pq.add(new Node(1, next[0], next[1]));
        }
        check[1] = true;

        while (!pq.isEmpty() || cv != V - 1) {
            Node cur = pq.poll();

            if (check[cur.v])
                continue;
            
            ans += cur.cost;
            check[cur.v] = true;
            cv++;

            for (int[] next : graph.get(cur.v)) {
                if (check[next[0]])
                    continue;

                pq.add(new Node(cur.v, next[0], next[1]));
            }

        }

        bw.write(ans + "\n");
        bw.flush();
    }
}
