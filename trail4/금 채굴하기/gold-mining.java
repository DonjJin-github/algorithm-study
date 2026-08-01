import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int k=0;k<=N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    int gold = get(new int[]{i,j}, k);
                    int getCost = (k*k) + (k+1)*(k+1);
                    if(gold*M>=getCost){
                        ans = Math.max(ans, gold);
                    }
                }
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }
    static int get(int[]start, int K){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N+1][N+1];
        visit[start[0]][start[1]] = true;
        q.add(new int[]{start[0], start[1], 0});
        
        int count = 0;
        if(arr[start[0]][start[1]] == 1)
            count++;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(cur[2]+1>K)
                    continue;
                q.add(new int[]{nx, ny, cur[2]+1});
                visit[nx][ny] = true;
                if(arr[nx][ny]==1)
                    count++;
            }
        }
        return count;
    }
}