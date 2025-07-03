import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Queue<int[]> bfs = new LinkedList<>();
        for (int num = 0; num < T; num++) {
            int count = 0;
            bfs.clear();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[M][N];
            visit = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                Arrays.fill(arr[i], 0);
                Arrays.fill(visit[i], false);
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] != 1 || visit[i][j])
                        continue;
                    count++;
                    bfs.add(new int[] { i, j });
                    visit[i][j] = true;
                    while (!bfs.isEmpty()) {
                        int[] cur = bfs.poll();

                        for (int k = 0; k < 4; k++) {
                            int checkx = cur[0] + dx[k];
                            int checky = cur[1] + dy[k];

                            if (checkx < 0 || checky < 0 || checkx >= M || checky >= N)
                                continue;
                            if (arr[checkx][checky] != 1 || visit[checkx][checky])
                                continue;

                            bfs.add(new int[] { checkx, checky });
                            visit[checkx][checky] = true;
                        }

                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
