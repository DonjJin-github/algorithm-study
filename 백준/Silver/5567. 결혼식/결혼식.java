import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int ans = 0;

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(1);
        dist[1]=0;

        while (!bfs.isEmpty()) {
            int vertex = bfs.poll();

            for (int next : graph.get(vertex)) {
                if (dist[next] != -1)
                    continue;

                bfs.add(next);
                dist[next] = dist[vertex] + 1;
                if (dist[next] == 1 || dist[next] == 2) {
                    ans++;
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
