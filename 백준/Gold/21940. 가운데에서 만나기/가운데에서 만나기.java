import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[] city;

    static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
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

        graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], 200000);
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u][v] = Math.min(cost, graph[u][v]);
        }

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        city = new int[K];

        for (int i = 0; i < K; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int s = 1; s <= N; s++) {
                for (int t = 1; t <= N; t++) {
                    graph[s][t] = Math.min(graph[s][t], graph[s][i] + graph[i][t]);
                }
            }
        }

        PriorityQueue<int[]> maxCity = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 1; i <= N; i++) {
            int max = 0;

            for (int friends : city) {
                int d = graph[friends][i] + graph[i][friends];
                if (max < d) {
                    max = d;
                }
            }
            maxCity.add(new int[] { i, max });
        }

        int min = Integer.MAX_VALUE;
        for (int[] temp : maxCity) {
            min = Math.min(min, temp[1]);
        }

        for (int[] temp : maxCity) {
            if (temp[1] == min) {
                bw.write(temp[0] + " ");
            }
        }

        bw.flush();
    }
}
