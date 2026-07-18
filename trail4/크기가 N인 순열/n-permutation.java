import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visit;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        print(new ArrayList<>());
        bw.flush();
    }
    static void print(ArrayList<Integer> list)throws IOException {
        if(list.size() == N){
            for(int temp : list){
                bw.write(temp+" ");
            }
            bw.write("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            if(visit[i])
                continue;
            
            list.add(i);
            visit[i] = true;
            print(list);
            list.remove(list.size()-1);
            visit[i] = false;
        }
    }
}
