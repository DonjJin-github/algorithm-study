import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int count = 0; count < T; count++) {
            Queue<int[]> bfs = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            visit = new boolean[N][N];

            String[] temp = br.readLine().split(" ");
            int startX = Integer.parseInt(temp[0]);
            int startY = Integer.parseInt(temp[1]);

            temp = br.readLine().split(" ");
            int endX = Integer.parseInt(temp[0]);
            int endY = Integer.parseInt(temp[1]);

            if (startX == endX && startY == endY) {
                bw.write("0\n");
                continue;
            }

            visit[startX][startY] = true;
            bfs.add(new int[] { startX, startY });

            boolean found = false;

            while (!bfs.isEmpty() && !found) {
                int[] cur = bfs.poll();

                for (int i = 0; i < 8; i++) {
                    int checkx = cur[0] + dx[i];
                    int checky = cur[1] + dy[i];

                    if (checkx < 0 || checky < 0 || checkx >= N || checky >= N)
                        continue;
                    if (visit[checkx][checky])
                        continue;

                    visit[checkx][checky] = true;
                    arr[checkx][checky] = arr[cur[0]][cur[1]] + 1;
                    bfs.add(new int[] { checkx, checky });

                    if (checkx == endX && checky == endY) {
                        bw.write(arr[checkx][checky] + "\n");
                        found = true;
                        break;
                    }
                }
            }
        }

        bw.flush();
    }
}
