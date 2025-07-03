import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] color;
    static char[][] scolor;
    static boolean[][] visit;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int countgeneral = 0;
        int count = 0;
        color = new char[N][N];
        scolor = new char[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                color[i][j] = temp.charAt(j);
                if (temp.charAt(j) == 'G')
                    scolor[i][j] = 'R';
                else
                    scolor[i][j] = temp.charAt(j);
            }
        }

        Queue<int[]> bfs = new LinkedList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (visit[x][y])
                    continue;
                countgeneral++;
                bfs.add(new int[] { x, y });
                visit[x][y] = true;
                while (!bfs.isEmpty()) {
                    int[] cur = bfs.poll();

                    for (int i = 0; i < 4; i++) {
                        int checkx = cur[0] + dx[i];
                        int checky = cur[1] + dy[i];

                        if (checkx < 0 || checky < 0 || checkx >= N || checky >= N)
                            continue;
                        if (visit[checkx][checky] || color[checkx][checky] != color[cur[0]][cur[1]])
                            continue;
                        visit[checkx][checky] = true;
                        bfs.add(new int[] { checkx, checky });
                    }
                }
            }
        }

        bfs.clear();
        visit = new boolean[N][N];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (visit[x][y])
                    continue;
                count++;
                bfs.add(new int[] { x, y });
                visit[x][y] = true;
                while (!bfs.isEmpty()) {
                    int[] cur = bfs.poll();

                    for (int i = 0; i < 4; i++) {
                        int checkx = cur[0] + dx[i];
                        int checky = cur[1] + dy[i];

                        if (checkx < 0 || checky < 0 || checkx >= N || checky >= N)
                            continue;
                        if (visit[checkx][checky] || scolor[checkx][checky] != scolor[cur[0]][cur[1]])
                            continue;
                        visit[checkx][checky] = true;
                        bfs.add(new int[] { checkx, checky });
                    }
                }
            }
        }
        bw.write(countgeneral +" "+count+ "\n");
        bw.flush();
    }
}
