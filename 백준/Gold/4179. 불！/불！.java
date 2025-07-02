import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char arr[][];
    static int fire[][];
    static int escape[][];
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        fire = new int[R][C];
        escape = new int[R][C];
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = temp.charAt(j);
                if (arr[i][j] == 'F'){
                    q1.add(new int[] { i, j });
                    fire[i][j]=1;
                }
                if (arr[i][j] == 'J'){
                    q2.add(new int[] { i, j });
                    escape[i][j]=1;
                }
            }
        }

        while (!q1.isEmpty()) {
            int cur[] = q1.poll();

            for (int i = 0; i < 4; i++) {
                int checkx = cur[0] + dx[i];
                int checky = cur[1] + dy[i];

                if (checkx < 0 || checky < 0 || checkx >= R || checky >= C)
                    continue;
                if (fire[checkx][checky] > 0 || arr[checkx][checky] == '#')
                    continue;
                fire[checkx][checky] = fire[cur[0]][cur[1]] + 1;
                q1.add(new int[] { checkx, checky });
            }
        }

        while (!q2.isEmpty()) {
            int cur[] = q2.poll();

            for (int i = 0; i < 4; i++) {
                int checkx = cur[0] + dx[i];
                int checky = cur[1] + dy[i];

                if (checkx < 0 || checky < 0 || checkx >= R || checky >= C) {
                    bw.write((escape[cur[0]][cur[1]]) + "\n");
                    bw.flush();
                    return;
                }
                if (escape[checkx][checky] > 0 || arr[checkx][checky] == '#')
                    continue;
                if (fire[checkx][checky] > 0 && fire[checkx][checky]<=escape[cur[0]][cur[1]]+1)
                    continue;
                escape[checkx][checky] = escape[cur[0]][cur[1]] + 1;
                q2.add(new int[] { checkx, checky });
            }
        }

        bw.write("IMPOSSIBLE\n");
        bw.flush();
    }
}
