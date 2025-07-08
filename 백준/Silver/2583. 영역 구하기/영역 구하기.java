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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int num = 0;
        StringBuilder sb = new StringBuilder();

        arr = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++)
                    arr[x][y] = 1;
            }
        }

        Queue<int[]> bfs = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 || visit[i][j])
                    continue;

                visit[i][j] = true;
                bfs.add(new int[] { i, j });
                num++;
                int width = 0;
                while (!bfs.isEmpty()) {
                    int[] cur = bfs.poll();
                    width++;
                    for (int direction = 0; direction < 4; direction++) {
                        int checkx = cur[0] + dx[direction];
                        int checky = cur[1] + dy[direction];

                        if (checkx < 0 || checky < 0 || checkx >= N || checky >= M)
                            continue;
                        if (visit[checkx][checky] || arr[checkx][checky] == 1)
                            continue;
                        visit[checkx][checky] = true;
                        bfs.add(new int[] { checkx, checky });
                    }
                }
                sb.append(width + " ");
            }
        }

        if (num == 0) {
            bw.write(num + "\n" + "0");
            bw.flush();
            return;
        }

        String[] temp = sb.toString().trim().split(" ");
        int index = temp.length;
        int[] ans = new int[index];

        for (int i = 0; i < index; i++)
            ans[i] = Integer.parseInt(temp[i]);
        Arrays.sort(ans);
        bw.write(num + "\n");
        for (int i = 0; i < index; i++)
            bw.write(ans[i] + " ");
        
        bw.flush();
    }
}
