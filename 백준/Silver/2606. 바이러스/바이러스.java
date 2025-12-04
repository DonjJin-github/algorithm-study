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

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];

        queue.add(1);
        visit[1] = true;
        
        int ans = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int next : graph.get(vertex)) {
                if (visit[next])
                    continue;
                queue.add(next);
                visit[next] = true;
                ans++;
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}
