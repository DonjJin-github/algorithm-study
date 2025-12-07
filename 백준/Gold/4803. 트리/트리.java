import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int parent[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int count = 0;
            visited = new boolean[N + 1];
            parent = new int[N + 1];
            
            for (int i = 1; i <= N; i++) {
                if (!visited[i])
                    if (isTree(i)) {
                        count++;
                    }
            }
            if (count > 1)
                bw.write("Case " + testCase + ": A forest of " + count + " trees.\n");
            else if (count == 1)
                bw.write("Case " + testCase + ": There is one tree.\n");
            else
                bw.write("Case " + testCase + ": No trees.\n");

            testCase++;
        }
        bw.flush();
    }

    static boolean isTree(int start) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(start);
        visited[start] = true;
        parent[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                    parent[child] = node;
                } else if (child != parent[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}