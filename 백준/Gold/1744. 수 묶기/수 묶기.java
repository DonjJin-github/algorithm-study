import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] list = new long[N];
        int temp = -1;
        long ans = 0;

        for (int i = 0; i < N; i++) {
            list[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(list);

        for (int i = N-1; i >=0; i--) {
            if(list[i]<=0){
                temp = i;
                break;
            }
            if (i - 1 >= 0 && (list[i] * list[i - 1] > list[i] + list[i - 1])) {
                ans += list[i] * list[i - 1];
                i--;
            } else {
                ans += list[i];
            }
        }

        for (int i = 0; i <= temp; i++) {
            if (i + 1 < N && (list[i] * list[i + 1] > list[i] + list[i + 1])) {
                ans += list[i] * list[i + 1];
                i++;
            } else {
                ans += list[i];
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}
