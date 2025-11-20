import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] lan = new long[k];

        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        long left = 1;             
        long right = lan[k - 1];    
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0; 
            for (int i = 0; i < k; i++) {
                count += lan[i] / mid;
            }

            if (count >= n) {
                ans = mid;       
                left = mid + 1;   
            } else {
                right = mid - 1;  
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
