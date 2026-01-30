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
            return Integer.compare(cost, newNode.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        check = new boolean[N + 1];
        long ans = 0;
        int cv = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = i;
            for (int j = 1; j <= N; j++) {
                int v = j;
                int cost = Integer.parseInt(st.nextToken());

                if (i == v)
                    continue;

                graph.get(u).add(new int[] { v, cost });
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        check[1] = true;
        for (int[] next : graph.get(1)) {
            pq.add(new Node(1, next[0], next[1]));
        }

        while (cv < N - 1) {
            Node cur = pq.poll();

            if(check[cur.v])
                continue;

            check[cur.v] = true;
            ans+=cur.cost;
            cv++;

            for(int[] next : graph.get(cur.v)){
                if(check[next[0]])
                    continue;

                pq.add(new Node(cur.v,next[0],next[1]));
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}
