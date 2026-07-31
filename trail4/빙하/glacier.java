import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] ans = {0, 0};
        while(true){
            ans[1] = countIce();
            bfs();
            ans[0]++;
            if(countIce() == 0)
                break;
        }
        bw.write(ans[0]+" "+ans[1]+"\n");
        bw.flush();
    }
    static int countIce(){
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        HashSet<int[]> list = new HashSet<>();
        visit = new boolean[N][M];

        q.add(new int[]{0,0});
        visit[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M)
                    continue;
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny] == 1){
                    list.add(new int[]{nx, ny});
                    continue;
                }
                visit[nx][ny] = true;
                q.add(new int[]{nx, ny});

            }
        }
        for(int[] temp : list)
            arr[temp[0]][temp[1]] = 0;
    }
}