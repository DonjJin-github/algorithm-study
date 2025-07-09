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

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        int ans = Integer.MIN_VALUE;
        int count;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        for (int depth = 0; depth <= max; depth++) {
            Queue<int[]> bfs = new LinkedList<>();
            visit = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] || arr[i][j] <= depth)
                        continue;
                    visit[i][j] = true;
                    count++;
                    bfs.add(new int[] { i, j });

                    while (!bfs.isEmpty()) {
                        int cur[] = bfs.poll();

                        for (int direction = 0; direction < 4; direction++) {
                            int checkx = cur[0] + dx[direction];
                            int checky = cur[1] + dy[direction];

                            if (checkx < 0 || checky < 0 || checkx >= N || checky >= N)
                                continue;
                            if (visit[checkx][checky] || arr[checkx][checky] <= depth)
                                continue;
                            visit[checkx][checky] = true;
                            bfs.add(new int[] { checkx, checky });
                        }
                    }
                }
            }
            ans = Math.max(count,ans);
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}
