import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++)
            Arrays.fill(graph[i], 10000000);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u][v] = Math.min(cost, graph[u][v]);
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n; s++) {
                for (int t = 1; t <= n; t++) {
                    graph[s][t] = Math.min(graph[s][t], graph[s][i] + graph[i][t]);
                    if (s == t)
                        graph[s][t] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 10000000)
                    bw.write("0 ");
                else
                    bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();

    }
}
