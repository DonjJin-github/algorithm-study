import java.io.*;
import java.util.*;

public class Main {
    static int[][][] arr;
    static int dx[] = { -1, 0, 1, 0, 0, 0 };
    static int dy[] = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int ans = 0;

        arr = new int[N][M][H];
        Queue<int[]> bfs = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[j][k][i] = Integer.parseInt(st.nextToken());
                    if (arr[j][k][i] == 1)
                        bfs.add(new int[] { j, k, i });
                }
            }
        }
        
        while (!bfs.isEmpty()) {
            int[] cur = bfs.poll();

            for (int i = 0; i < 6; i++) {
                int checkx = cur[0] + dx[i];
                int checky = cur[1] + dy[i];
                int checkz = cur[2] + dz[i];

                if (checkx < 0 || checky < 0 || checkz < 0 || checkx >= N || checky >= M || checkz >= H)
                    continue;
                if (arr[checkx][checky][checkz] != 0)
                    continue;
                ans++;
                arr[checkx][checky][checkz] = arr[cur[0]][cur[1]][cur[2]] +1;
                bfs.add(new int[] { checkx, checky, checkz });
            }
        }

        ans = Integer.MIN_VALUE;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k][i] == 0) {
                        ans = -1;
                        bw.write(ans + "\n");
                        bw.flush();
                        return;
                    }
                    ans = Math.max(ans, arr[j][k][i]);
                }
            }
        }

        bw.write((ans - 1) + "\n");
        bw.flush();

    }
}
