import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] ans;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        ans = new int[N][N];
        visit = new boolean[N][N];
        
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){
                    ans[i][j] = -1;
                    visit[i][j] = true;
                }
                else if(arr[i][j] == 2){
                    q.add(new int[]{i,j,0});
                    visit[i][j] = true;
                    ans[i][j] = 0;
                }                
                else{
                    ans[i][j] = -2;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;
                if(visit[nx][ny])
                    continue;

                q.add(new int[]{nx, ny, cur[2]+1});
                visit[nx][ny] = true;
                ans[nx][ny] = cur[2]+1;
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                bw.write(ans[i][j]+" ");
            bw.write("\n");
        }
        bw.flush();
    }
}