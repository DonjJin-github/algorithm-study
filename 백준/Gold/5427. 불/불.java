import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int[][] fire;
    static int[][] escape;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            Queue<int[]> bfs1 = new LinkedList<>();
            Queue<int[]> bfs2 = new LinkedList<>();

            arr = new char[h][w];
            fire = new int[h][w];
            escape = new int[h][w];

            for (int i = 0; i < h; i++) {
                String temp = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = temp.charAt(j);
                    if (arr[i][j] == '@') {
                        escape[i][j] = 1;
                        bfs1.add(new int[] { i, j });
                    }
                    if (arr[i][j] == '*') {
                        fire[i][j] = 1;
                        bfs2.add(new int[] { i, j });
                    }

                }
            }

            while (!bfs2.isEmpty()) {
                int cur[] = bfs2.poll();

                for (int i = 0; i < 4; i++) {
                    int checkx = cur[0] + dx[i];
                    int checky = cur[1] + dy[i];

                    if (checkx < 0 || checky < 0 || checkx >= h || checky >= w)
                        continue;
                    if (arr[checkx][checky] == '#' || fire[checkx][checky]>0)
                        continue;

                    
                    fire[checkx][checky] = fire[cur[0]][cur[1]] + 1;
                    bfs2.add(new int[] { checkx, checky });
                }
            }
            boolean found = false;
            while (!bfs1.isEmpty() && !found) {
                int cur[] = bfs1.poll();

                for (int i = 0; i < 4; i++) {
                    int checkx = cur[0] + dx[i];
                    int checky = cur[1] + dy[i];

                    if (checkx < 0 || checky < 0 || checkx >= h || checky >= w) {
                        bw.write(escape[cur[0]][cur[1]] + "\n");
                        found = true;
                        break;
                    }
                    if (arr[checkx][checky] == '#' || escape[checkx][checky] > 0)
                        continue;
                    if (fire[checkx][checky] != 0 && escape[cur[0]][cur[1]] + 1 >= fire[checkx][checky])
                        continue;

                    escape[checkx][checky] = escape[cur[0]][cur[1]] + 1;
                    bfs1.add(new int[] { checkx, checky });
                }
            }

            if (!found)
                bw.write("IMPOSSIBLE\n");
        }
        bw.flush();
    }
}
