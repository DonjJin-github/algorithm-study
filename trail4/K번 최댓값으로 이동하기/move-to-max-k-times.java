import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int N;
    static int K;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] start = new int[2];
        start[0] = Integer.parseInt(st.nextToken())-1;
        start[1] = Integer.parseInt(st.nextToken())-1;

        for(int i=0;i<K;i++){
            int[] check = bfs(start);
            if(check[0] == N && check[1] == N){
                break;
            }
            start[0] = check[0];
            start[1] = check[1];
        }
        bw.write((start[0]+1) +" "+(start[1]+1));
        bw.flush();
    }
    static int[] bfs(int[] start){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        q.add(new int[]{start[0], start[1]});
        visit[start[0]][start[1]] = true;

        int[] next = {N, N};
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;
                if(visit[nx][ny] || arr[nx][ny]>=arr[start[0]][start[1]])
                    continue;
                            
                if(max < arr[nx][ny]){
                    next[0] = nx;
                    next[1] = ny;
                    max = arr[nx][ny];
                }
                else if(max == arr[nx][ny]){
                    if(nx<next[0]){
                        next[0] = nx;
                        next[1] = ny;
                        max = arr[nx][ny];
                    }else if(nx == next[0] && ny<next[1]){
                        next[0] = nx;
                        next[1] = ny;
                        max = arr[nx][ny];
                    }
                }
                q.add(new int[]{nx, ny});
                visit[nx][ny] = true;
            }
        }
        
        return next;
    }
}
