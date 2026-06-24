import java.util.*;
import java.io.*;

public class Main {
    static boolean visit[];
    static int graph[][];
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u =  Integer.parseInt(st.nextToken());
            int v =  Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        
        dfs(1,n);
        System.out.print(ans);
    }
    static void dfs(int node, int n){
        visit[node] = true;
        ans++;

        for(int i=1;i<=n;i++){
            if(graph[node][i]==1){
                if(!visit[i]){
                    dfs(i,n);
                }
            }
        }
    }
}