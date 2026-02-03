import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        items = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], 10000);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u][v] = Math.min(graph[u][v], cost);
            graph[v][u] = Math.min(graph[v][u], cost);
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n; s++) {
                for (int t = 1; t <= n; t++) {
                    graph[s][t] = Math.min(graph[s][i] + graph[i][t], graph[s][t]);
                    if (s == t)
                        graph[s][t] = 0;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if(graph[i][j]<= m)
                    temp+=items[j];
            }
            ans = Math.max(temp,ans);
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}
