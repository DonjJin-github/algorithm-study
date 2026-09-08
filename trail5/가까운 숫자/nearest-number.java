import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int ans = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            Integer a1 = set.higher(num);
            Integer a2 = set.lower(num);
            set.add(num);

            if(a1 != null){
                ans = Math.min(ans, Math.abs(a1-num));
            }
            if(a2 != null){
                ans = Math.min(ans, Math.abs(a2-num));
            }
            bw.write(ans+"\n");
        }
        
        bw.flush();
    }
}