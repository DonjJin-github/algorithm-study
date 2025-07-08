import java.io.*;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int apt = 0;

        arr = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        Queue<int[]> bfs = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0 || visit[i][j])
                    continue;
                visit[i][j] = true;
                apt++;
                int aptnum = 0;
                bfs.add(new int[] { i, j });

                while (!bfs.isEmpty()) {
                    int[] cur = bfs.poll();
                    aptnum++;
                    for (int k = 0; k < 4; k++) {
                        int checkx = cur[0] + dx[k];
                        int checky = cur[1] + dy[k];

                        if (checkx < 0 || checky < 0 || checkx >= N || checky >= N)
                            continue;
                        if (arr[checkx][checky] == 0 || visit[checkx][checky])
                            continue;

                        visit[checkx][checky] = true;
                        bfs.add(new int[] { checkx, checky });
                    }

                }
                ans.add(aptnum);
            }
        }
        bw.write(apt + "\n");
        Collections.sort(ans);
        for (Integer temp : ans) {
            bw.write(temp+"\n");
        }
        bw.flush();
    }
}
