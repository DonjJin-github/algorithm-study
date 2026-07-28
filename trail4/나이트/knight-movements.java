import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] distance = new int[N][N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start[] = new int[2];
        int end[] = new int[2];

        start[0] = Integer.parseInt(st.nextToken())-1;
        start[1] = Integer.parseInt(st.nextToken())-1;
        end[0] = Integer.parseInt(st.nextToken())-1;
        end[1] = Integer.parseInt(st.nextToken())-1;
        
        for(int i=0;i<N;i++)
            Arrays.fill(distance[i],-1);

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1]});
        distance[start[0]][start[1]] = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<8;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;
                if(distance[nx][ny] != -1)
                    continue;

                distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        bw.write(distance[end[0]][end[1]]+"\n");
        bw.flush();        
    }
}
