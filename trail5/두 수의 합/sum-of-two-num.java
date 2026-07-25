import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int ans = 0;
        for(int i=0;i<N;i++){
            int a = Integer.parseInt(st.nextToken());
            ans += map.getOrDefault(K-a, 0);

            map.put(a, map.getOrDefault(a,0)+1);
        }
        
        bw.write(ans+"\n");
        bw.flush();
    }
}
