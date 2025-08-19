import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        boolean visit[] = new boolean[N];
        int index = 0;
        int count = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
            visit[i] = false;
        }

        while (q.size() != N) {
            if (count == K - 1 && visit[index] == false) {
                q.add(arr[index]);
                visit[index] = true;
                count = 0;
                continue;
            }

            if (visit[index] == true) {
                index++;
                if (index >= N)
                    index -= N;
            } else {
                count++;
                index++;
                if (index >= N)
                    index -= N;
            }
        }

        bw.write("<");
        for (int i = 0; i < N; i++) {
            bw.write(q.poll() + "");
            if (i == N - 1)
                bw.write(">");
            else
                bw.write(", ");
        }
        bw.flush();
    }
}
