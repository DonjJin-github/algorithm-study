import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] distance;
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        distance = new boolean[N][M];
        Queue<int[]> bfs = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    bfs.add(new int[] { i, j });
            }
        }
        int ans = Integer.MIN_VALUE;

        while (!bfs.isEmpty()) {
            int cur[] = bfs.poll();
            for (int i = 0; i < 4; i++) {
                int checkx = cur[0] + dx[i];
                int checky = cur[1] + dy[i];

                if (checkx < 0 || checky < 0 || checkx >= N || checky >= M)
                    continue;
                if (arr[checkx][checky] != 0)
                    continue;
                arr[checkx][checky] = arr[cur[0]][cur[1]] + 1;
                bfs.add(new int[] { checkx, checky });
            }
        }

        outer: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    ans = -1;
                    break outer;
                }
                ans = Math.max(ans, arr[i][j]);
            }
        }
        if (ans == -1)
            bw.write((ans) + "\n");
        else
            bw.write((ans - 1) + "\n");

        bw.flush();
    }
}
