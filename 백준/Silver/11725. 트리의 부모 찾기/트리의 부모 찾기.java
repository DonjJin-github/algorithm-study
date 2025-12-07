import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        bfs(1);

        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.flush();

    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        parent[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child : tree.get(node)) {
                if (parent[child] == -1) {
                    parent[child] = node;
                    queue.add(child);
                }
            }
        }
    }
}