import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] distance;
    static int[] dx = {-1 , 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        distance = new int[N][M];

        for(int i=0;i<N;i++){
            String[] line = br.readLine().split("");
            for(int j=0;j<M;j++)
                arr[i][j] = Integer.parseInt(line[j]);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        distance[0][0] = 1;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int temp = distance[cur[0]][cur[1]];

            for(int dir = 0;dir<4;dir++){
                int checkx = cur[0]+dx[dir];
                int checky = cur[1]+dy[dir];

                if(checkx<0||checkx>=N||checky<0||checky>=M)
                    continue;
                if(distance[checkx][checky] > 0||arr[checkx][checky]==0)
                    continue;
                distance[checkx][checky] = temp+1;
                q.add(new int[]{checkx,checky});
            }
        }


        bw.write(distance[N-1][M-1]+"\n");
        bw.flush();
    }
}
