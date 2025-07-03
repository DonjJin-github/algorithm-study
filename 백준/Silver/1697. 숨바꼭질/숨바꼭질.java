import java.io.*;
import java.util.*;

public class Main {
    static int arr[] = new int[200000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(N);
        arr[N] = 1;

        while (arr[K] == 0) {
            int cur = bfs.poll();

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next >= 200000) continue;
                if (arr[next] > 0) continue;

                arr[next] = arr[cur] + 1;
                bfs.add(next);
            }
        }

        bw.write((arr[K] - 1) + "\n");
        bw.flush();
    }
}
