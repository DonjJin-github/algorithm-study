import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()) - 1;
        int G = Integer.parseInt(st.nextToken()) - 1;
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        arr = new int[F];
        visit = new boolean[F];

        Queue<Integer> bfs = new LinkedList<>();
        arr[S] = 1;
        visit[S] = true;
        bfs.add(S);

        while (!bfs.isEmpty()) {
            int cur = bfs.poll();

            for (int i : new int[] { U, -D }) {
                int move = cur + i;

                if (move < 0 || move >= F)
                    continue;
                if (visit[move] || arr[move] != 0)
                    continue;
                if (move == G) {
                    bw.write(arr[cur] + "\n");
                    bw.flush();
                    return;
                }
                arr[move] = arr[cur] + 1;
                visit[move] = true;
                bfs.add(move);
            }
        }
        if (S == G)
            bw.write("0\n");
        else
            bw.write("use the stairs\n");
        bw.flush();
    }
}
