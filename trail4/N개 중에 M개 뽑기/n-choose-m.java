import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        choose(1, new ArrayList<>());
        bw.flush();
    }
    static void choose(int start, ArrayList<Integer> list) throws IOException {
        if(list.size() == M){
            for(int print : list)
                bw.write(print+" ");
            
            bw.write("\n");
            return;
        }

        for(int i=start;i<=N;i++){
            list.add(i);
            choose(i+1, list);
            list.remove(list.size()-1);
        }
    }
}