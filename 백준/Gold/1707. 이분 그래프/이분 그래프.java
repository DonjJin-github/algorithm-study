import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int x = 0; x < testCase; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

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

            boolean check = true;
            visited = new boolean[N + 1];
            color = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                if(visited[i])
                    continue;

                if(!check)
                    break;
                check = bfs(i);
            }

            if (check)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }
        bw.flush();
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        color[start] = 1;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int next : graph.get(vertex)) {
                if (!visited[next]) {
                    visited[next] = true;
                    color[next] = -color[vertex];
                    queue.add(next);
                } else if (color[vertex] == color[next]) {
                    return false;
                }
            }
        }
        return true;
    }
}