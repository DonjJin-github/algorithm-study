import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[][] graph;
    static boolean[] visit;
    static final int INF = 20000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        
        graph = new int[n+1][n+1];
        visit = new boolean[n+1];
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
            for(int j=0;j<=n;j++){
                graph[i][j] = INF;
                if(i==j)
                    graph[i][j] = 0;
            }
        }
        
        for(int i=0;i<fares.length;i++){
            int u = fares[i][0];
            int v = fares[i][1];
            int cost = fares[i][2];
            
            graph[u][v] = Math.min(graph[u][v], cost);
            graph[v][u] = Math.min(graph[v][u], cost);
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        for(int i=1;i<=n;i++){
            for(int k=1;k<=n;k++){
                for(int t=1;t<=n;t++){
                    if(graph[k][t]>graph[k][i]+graph[i][t]){
                        graph[k][t] = graph[k][i]+graph[i][t];
                    }
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{s,0});
        visit[s] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            answer = Math.min(answer,graph[cur[0]][a]+graph[cur[0]][b]+cur[1]);
            
            for(int next : list.get(cur[0])){
                if(!visit[next]){
                    q.add(new int[]{next,graph[s][next]});
                    visit[next] = true;
                }
            }
        }
        
        return answer;
    }
}