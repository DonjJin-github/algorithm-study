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

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) != 0) {
                    graph.get(i).add(j);
                }
            }
        }

        int[][] ans = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            bfs.add(i);
            while (!bfs.isEmpty()) {
                int vertex = bfs.poll();
                for (int next : graph.get(vertex)) {
                    if(ans[i][next]==0){
                        ans[i][next] = 1;
                        bfs.add(next);
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bw.write(ans[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
