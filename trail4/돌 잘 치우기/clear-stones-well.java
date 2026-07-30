import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int N;
    static int K;
    static int M;
    static int[][] arr;
    static ArrayList<int[]> stone = new ArrayList<>();
    static ArrayList<int[]> start = new ArrayList<>();
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    stone.add(new int[]{i, j});
                }
            }
        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            start.add(new int[]{Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1});
        }

        backtracking(0, new ArrayList<>());

        bw.write(ans+"\n");
        bw.flush();
    }
    static void backtracking(int idx, ArrayList<Integer> list){
        if(idx>stone.size())
            return;
        if(list.size() == M){
            for(int t : list){
                arr[stone.get(t)[0]][stone.get(t)[1]] = 0;
            }
            int max = bfs();
            for(int t : list){
                arr[stone.get(t)[0]][stone.get(t)[1]] = 1;
            }
            ans = Math.max(max, ans);
            return;
        }
        
        list.add(idx);
        backtracking(idx+1, list);
        list.remove(list.size()-1);

        backtracking(idx+1, list);
    }
    static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        int count = 0;
        
        for(int[] temp : start){
            q.add(new int[]{temp[0], temp[1]});
            visit[temp[0]][temp[1]] = true;
            count++;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;
                if(visit[nx][ny] || arr[nx][ny] == 1)
                    continue;
                
                count++;
                visit[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return count;
    }
}
