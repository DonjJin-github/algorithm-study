import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static Deque<Integer>[][] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        route = new ArrayDeque[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                graph[i][j] = 10000000;
                route[i][j] = new ArrayDeque<>();
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (graph[u][v] > cost) {
                graph[u][v] = cost;
                route[u][v].clear();
                route[u][v].addFirst(u);
                route[u][v].addLast(v);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n; s++) {
                for (int t = 1; t <= n; t++) {
                    if (s == t) {
                        graph[s][t] = 0;
                    } else if (graph[s][t] > graph[s][i] + graph[i][t]) {
                        graph[s][t] = graph[s][i] + graph[i][t];

                        route[s][t].clear();

                        if (route[s][i].isEmpty()) {
                            route[s][t].addLast(s);
                            route[s][t].addLast(i);
                        } else
                            for (int temp : route[s][i])
                                route[s][t].addLast(temp);

                        route[s][t].pollLast();

                        if (route[i][t].isEmpty()) {
                            route[s][t].addLast(i);
                            route[s][t].addLast(t);
                        } else
                            for (int temp : route[i][t])
                                route[s][t].addLast(temp);

                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 10000000) {
                    graph[i][j] = 0;
                }
                bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (route[i][j].isEmpty())
                    bw.write("0");
                else {
                    bw.write(route[i][j].size() + " ");
                    for (int temp : route[i][j]) {
                        bw.write(temp + " ");
                    }
                }
                bw.write("\n");
            }
        }
        bw.flush();
    }
}
