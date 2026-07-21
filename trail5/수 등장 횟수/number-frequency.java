import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int k = Integer.parseInt(st.nextToken());
            map.put(k, map.getOrDefault(k,0)+1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int k = Integer.parseInt(st.nextToken());
            bw.write(map.getOrDefault(k,0)+" ");
        }
        bw.flush();
    }
}