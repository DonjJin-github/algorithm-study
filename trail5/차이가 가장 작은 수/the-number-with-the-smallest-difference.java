import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            set.add(num);

            int check = num+M;
            Integer a1 = set.ceiling(check);
            if(a1!=null)
                ans = Math.min(ans, a1-num);
            
            check = num-M;
            a1 = set.floor(check);
            if(a1!=null)
                ans = Math.min(ans, num-a1);
        }
        if(ans == Integer.MAX_VALUE)
            bw.write("-1\n");
        else
            bw.write(ans+"\n");
        bw.flush();
    }
}