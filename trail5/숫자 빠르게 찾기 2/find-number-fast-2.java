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

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<M;i++){
            int num = Integer.parseInt(br.readLine());
            Integer print = set.ceiling(num);
            if(print==null)
                bw.write("-1\n");
            else
                bw.write(print+"\n");
        }

        bw.flush();
    }
}