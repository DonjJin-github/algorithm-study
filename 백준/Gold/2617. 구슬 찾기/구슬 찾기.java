import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph1;
    static ArrayList<ArrayList<Integer>> graph2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph1 = new ArrayList<>();
        graph2 = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph1.get(u).add(v);
            graph2.get(v).add(u);
        }

        int ans = 0;
        int median = (N + 1) / 2;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            if (bfs1(i) >= median) {
                ans++;
            }
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            if (bfs2(i) >= median) {
                ans++;
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }

    static int bfs1(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int next : graph1.get(vertex)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        return count;
    }
        static int bfs2(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int next : graph2.get(vertex)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        return count;
    }
}