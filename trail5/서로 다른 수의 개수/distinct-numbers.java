import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        bw.write(set.size()+"\n");
        bw.flush();
    }
}