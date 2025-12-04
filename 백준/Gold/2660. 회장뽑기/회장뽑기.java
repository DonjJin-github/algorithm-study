import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> bfs = new LinkedList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (u == -1 && v == -1)
                break;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int ans[][] = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            int count = 0;
            boolean visit[] = new boolean[N + 1];
            int[] distance = new int[N + 1];
            bfs.add(i);
            visit[i] = true;
            while (!bfs.isEmpty()) {
                int vertex = bfs.poll();

                for (int next : graph.get(vertex)) {
                    if (visit[next]) {
                        continue;
                    }
                    visit[next] = true;
                    distance[next] = distance[vertex] + 1;
                    count = Math.max(count, distance[next]);
                    bfs.add(next);
                }
            }
            ans[i][0] = count;
            ans[i][1] = i;
        }

        ans[0][0] = Integer.MAX_VALUE;

        Arrays.sort(ans, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int minScore = ans[0][0];
        List<Integer> candidates = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            if (ans[i][0] == minScore) {
                candidates.add(ans[i][1]);
            }
        }
        
        bw.write(minScore + " " + candidates.size() + "\n");
        for (int c : candidates) {
            bw.write(c + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
