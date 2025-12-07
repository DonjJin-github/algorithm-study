import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        if (k == 0) {
            bw.write(M + "\n");
            bw.flush();
            return;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            if (st.hasMoreTokens()) {
                for (int j = 1; j < temp; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    graph.get(u).add(v);
                    graph.get(v).add(u);
                }
            } else {
                graph.get(u).add(u);
            }
        }
        visited = new boolean[N+1];

        for (int start : queue) {
            bfs(start);
        }

        int ans1 = 0;
        int ans2 = 0;

        for (int i = 1; i <= N; i++) {
            for (int next : graph.get(i)) {
                if (!visited[next]) {
                    if (next == i)
                        ans1++;
                    else
                        ans2++;
                }
            }
        }

        int ans = ans1 + (ans2 / 2);

        bw.write(ans + "\n");
        bw.flush();
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int next : graph.get(vertex)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}