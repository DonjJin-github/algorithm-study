import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static int count = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int picture = 0;
        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 || visit[i][j])
                    continue;
                picture++;
                visit[i][j] = true;

                q.add(new int[] { i, j });

                count = 0;
                while (!q.isEmpty()) {
                    int cur[] = q.poll();
                    count++;
                    for (int k = 0; k < 4; k++) {
                        int checkx = cur[0] + dx[k];
                        int checky = cur[1] + dy[k];

                        if (checkx < 0 || checkx >= n || checky < 0 || checky >= m)
                            continue;
                        if (visit[checkx][checky] || arr[checkx][checky] != 1)
                            continue;
                        visit[checkx][checky] = true;
                        q.add(new int[] { checkx, checky });
                    }

                }
                max = Math.max(count, max);
            }
        }

        bw.write(picture + "\n" + max + "\n");
        bw.flush();
    }

}
