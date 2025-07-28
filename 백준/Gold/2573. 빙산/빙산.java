import java.io.*;
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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<int[]> icebfs = new LinkedList<>();
        arr = new int[N][M];

        int count = 0;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0) {
                    icebfs.add(new int[] { i, j });
                }
            }
        }

        while (true) {
            int[][] tempArr = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] > 0) {
                        int sea = 0;
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                                continue;
                            if (arr[nx][ny] == 0)
                                sea++;
                        }
                        tempArr[i][j] = Math.max(0, arr[i][j] - sea);
                    }
                }
            }

            icebfs.clear();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = tempArr[i][j];
                    if (arr[i][j] > 0) {
                        icebfs.add(new int[] { i, j });
                    }
                }
            }

            count = checksea(N, M);
            ans++;

            if (count > 1)
                break;
            if (icebfs.isEmpty()) {
                ans = 0;
                break;
            }
        }

        if (count == 0)
            bw.write(0 + "\n");
        else
            bw.write(ans + "\n");
        bw.flush();
    }

    static int checksea(int N, int M) {
        Queue<int[]> bfs = new LinkedList<>();
        visit = new boolean[N][M];
        int count = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (visit[x][y] || arr[x][y] == 0)
                    continue;
                bfs.add(new int[] { x, y });
                visit[x][y] = true;
                count++;

                while (!bfs.isEmpty()) {
                    int[] cur = bfs.poll();
                    for (int i = 0; i < 4; i++) {
                        int checkx = cur[0] + dx[i];
                        int checky = cur[1] + dy[i];

                        if (checkx < 0 || checky < 0 || checkx >= N || checky >= M) {
                            continue;
                        }
                        if (visit[checkx][checky] || arr[checkx][checky] == 0)
                            continue;
                        bfs.add(new int[] { checkx, checky });
                        visit[checkx][checky] = true;
                    }
                }
            }
        }

        return count;
    }
}
