import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] distance;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int N;
    static int K;
    static ArrayList<int[]> block = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;
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
                if(arr[i][j] == 1){
                    block.add(new int[]{i, j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken())-1;
        start[1] = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(st.nextToken())-1;
        end[1] = Integer.parseInt(st.nextToken())-1;

        dfs(0, new ArrayList<>());
        if(ans == Integer.MAX_VALUE)
            bw.write("-1");
        else
            bw.write(ans-1+" ");
        bw.flush();
    }
    static void dfs(int idx, ArrayList<Integer> list){
        if(idx>block.size())
            return;
        if(list.size()==K){
            for(int i : list){
                arr[block.get(i)[0]][block.get(i)[1]] = 0;
            }

            bfs();

            if(distance[end[0]][end[1]]!=0)
                ans = Math.min(ans, distance[end[0]][end[1]]);

            for(int i : list){
                arr[block.get(i)[0]][block.get(i)[1]] = 1;
            }
            return;
        }

        list.add(idx);
        dfs(idx+1, list);
        list.remove(list.size()-1);

        dfs(idx+1, list);
    }

    static void bfs(){
        distance = new int[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1]});
        distance[start[0]][start[1]] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;
                if(arr[nx][ny] == 1 || distance[nx][ny] != 0)
                    continue;
                
                q.add(new int[]{nx, ny});
                distance[nx][ny] = distance[cur[0]][cur[1]]+1;
            }
        }
    }
}