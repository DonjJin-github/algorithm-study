import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        int N = Integer.parseInt(br.readLine());
        int[][] flower = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int start = arr[sm - 1] + sd;
            int end = arr[em - 1] + ed;
            
            
            if (start < 60)
                start = 60;            

            flower[i][0] = start;
            flower[i][1] = end;
        }

        Arrays.sort(flower, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int ans = 0;
        int index = 0;
        int currentEnd = 60;
        int targetDate = 335;

        while (currentEnd < targetDate) {
            int maxEndThisTurn = 0;

            while (index < N && flower[index][0] <= currentEnd) {
                maxEndThisTurn = Math.max(maxEndThisTurn, flower[index][1]);
                index++;
            }

            if (maxEndThisTurn <= currentEnd) {
                ans = 0;
                break;
            }

            ans++;
            currentEnd = maxEndThisTurn;
        }

        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
