import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][][] arr;
    static int[][][] visit;
    static int[] dx = { -1, 0, 1, 0, 0, 0 };
    static int[] dy = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[] finish = new int[3];

            if (L == 0 && R == 0 && C == 0)
                break;

            arr = new char[R][C][L];
            visit = new int[R][C][L];
            Queue<int[]> bfs = new LinkedList<>();

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String temp = br.readLine();
                    for (int k = 0; k < C; k++) {
                        arr[j][k][i] = temp.charAt(k);
                        if (arr[j][k][i] == 'S') {
                            visit[j][k][i] = 1;
                            bfs.add(new int[] { j, k, i });
                        }
                        if (arr[j][k][i] == 'E') {
                            finish[0] = j; 
                            finish[1] = k;
                            finish[2] = i;
                        }
                    }
                }
                br.readLine();
            }
            boolean stop = false;

            while (!bfs.isEmpty() && !stop) {
                int cur[] = bfs.poll();

                for (int i = 0; i < 6; i++) {
                    int checkx = cur[0] + dx[i];
                    int checky = cur[1] + dy[i];
                    int checkz = cur[2] + dz[i];

                    if (checkx < 0 || checky < 0 || checkz < 0 || checkx >= R || checky >= C || checkz >= L)
                        continue;
                    if (visit[checkx][checky][checkz] > 0 || arr[checkx][checky][checkz] == '#')
                        continue;
                    if (finish[0] == checkx && finish[1] == checky && finish[2] == checkz) {
                        bw.write("Escaped in " + visit[cur[0]][cur[1]][cur[2]] + " minute(s).\n");
                        stop = true;
                        break;
                    }

                    visit[checkx][checky][checkz] = visit[cur[0]][cur[1]][cur[2]] + 1;
                    bfs.add(new int[] { checkx, checky, checkz });
                }
            }
            if (!stop)
                bw.write("Trapped!\n");
        }
        bw.flush();
    }
}
