import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

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
            graph.get(v).add(u);
        }

        int[] counts = new int[N + 1];
        int maxCount = 0;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            counts[i] = bfs(i);
            maxCount = Math.max(maxCount, counts[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (counts[i] == maxCount) {
                sb.append(i).append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
    
    static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);
        
        int count = 1;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        
        return count;
    }
}