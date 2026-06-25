import java.util.*;
import java.io.*;

public class Main {
    static int ans = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        backtracking(K,N);
        bw.flush();
    }
    static void backtracking(int K, int N) throws IOException {
        if(list.size() == N){
            for(int print : list)
                bw.write(print+" ");
            bw.write("\n");
            return;
        }

        for(int i=1;i<=K;i++){
            list.add(i);
            backtracking(K,N);
            list.remove(list.size()-1);
        }
    }
}