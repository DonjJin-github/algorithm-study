import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

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

        Queue<Integer> bfs = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        int[] dist = new int[N + 1];

        bfs.add(1);
        visit[1] = true;

        int max = Integer.MIN_VALUE;

        while (!bfs.isEmpty()) {
            int vertex = bfs.poll();

            for (int next : graph.get(vertex)) {
                if (!visit[next]) {
                    visit[next] = true;
                    dist[next] += dist[vertex] + 1;
                    bfs.offer(next);
                    max = Math.max(max, dist[next]);
                }
            }
        }

        int count = 0;
        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == max) {
                count++;
                if (!check) {
                    bw.write(i + " ");
                    check = true;
                }
            }
        }
        bw.write(max + " " + count + "\n");
        bw.flush();
    }
}