import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int N;
    static int K;
    static int U;
    static int D;
    static int[][] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        K  = Integer.parseInt(st.nextToken());
        U  = Integer.parseInt(st.nextToken());
        D  = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0, new ArrayList<>());
        bw.write(ans+"\n");
        bw.flush();
    }
    static void backtracking(int idx, ArrayList<int[]> list) {
        if (list.size() == K) {
            ans  = Math.max(ans, bfs(list));
            return;
        }
        if (idx >= N * N)
            return;

        int x = idx / N;
        int y = idx % N;

        list.add(new int[]{x, y});
        backtracking(idx + 1, list);
        list.remove(list.size() - 1);

        backtracking(idx + 1, list);
    }
    static int bfs(ArrayList<int[]> list){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        int count = 0;

        for(int[] add : list){
            q.add(new int[]{add[0],add[1]});
            visit[add[0]][add[1]] = true;
            count++;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;
                if(visit[nx][ny] || !( Math.abs(arr[nx][ny] - arr[cur[0]][cur[1]])>=U && Math.abs(arr[nx][ny] - arr[cur[0]][cur[1]])<=D ))
                    continue;
                
                q.add(new int[]{nx, ny});
                visit[nx][ny] = true;
                count++;
            }
        }
        return count;
    }
}