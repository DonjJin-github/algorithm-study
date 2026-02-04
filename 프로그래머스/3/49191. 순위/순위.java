import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();

    public int solution(int n, int[][] results) {
        int answer = 0;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int[] edge : results) {
            graph.get(edge[1]).add(edge[0]);
            reverseGraph.get(edge[0]).add(edge[1]);
        }

        for (int i = 1; i <= n; i++) {
            Queue<Integer> q = new ArrayDeque<>();
            Queue<Integer> rq = new ArrayDeque<>();
            boolean visited[] = new boolean[n+1];
            boolean rvisited[] = new boolean[n+1];

            int count1 = 0;
            int count2 = 0;
            q.add(i);
            rq.add(i);

            while (!q.isEmpty()) {
                int cur = q.poll();
                if(visited[cur])
                    continue;
                visited[cur] = true;
                count1++;
                for (int next : graph.get(cur)) {
                    q.add(next);
                }
            }
            
            while (!rq.isEmpty()) {
                int cur = rq.poll();
                if(rvisited[cur])
                    continue;
                rvisited[cur] = true;
                count2++;
                for (int next : reverseGraph.get(cur)) {
                    rq.add(next);
                }
            }
            if (count1+count2-1 == n)
                answer++;
        }

        return answer;
    }
}