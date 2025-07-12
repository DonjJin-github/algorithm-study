import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][][] visit;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        // 시작점이 도착점일 경우
        if (N == 1 && M == 1) {
            bw.write("1\n");
            bw.flush();
            return;
        }

        Queue<int[]> bfs = new LinkedList<>();
        visit = new int[N][M][2];
        visit[0][0][0] = 1;
        bfs.add(new int[] { 0, 0, 0 });

        while (!bfs.isEmpty()) {
            int cur[] = bfs.poll();

            for (int i = 0; i < 4; i++) {
                int checkx = cur[0] + dx[i];
                int checky = cur[1] + dy[i];

                if (checkx == N - 1 && checky == M - 1) {
                    bw.write(visit[cur[0]][cur[1]][cur[2]] + 1 + "\n");
                    bw.flush();
                    return;
                }

                if (checkx < 0 || checky < 0 || checkx >= N || checky >= M)
                    continue;

                if (arr[checkx][checky] == 0 && visit[checkx][checky][cur[2]] == 0) {
                    visit[checkx][checky][cur[2]] = visit[cur[0]][cur[1]][cur[2]] + 1;
                    bfs.add(new int[] { checkx, checky, cur[2] });
                }

                if (arr[checkx][checky] == 1 && cur[2] == 0 && visit[checkx][checky][1] == 0) {
                    visit[checkx][checky][1] = visit[cur[0]][cur[1]][cur[2]] + 1;
                    bfs.add(new int[] { checkx, checky, 1 });
                }
            }
        }
        bw.write(-1 + "\n");
        bw.flush();
    }
}
