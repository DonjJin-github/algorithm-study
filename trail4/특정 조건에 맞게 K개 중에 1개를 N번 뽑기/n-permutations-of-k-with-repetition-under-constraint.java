import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        count(new ArrayList<>());
        bw.flush();
    }
    static void count(ArrayList<Integer> list)throws IOException{
        if(list.size() == K){
            for(int print : list)
                bw.write(print+" ");
            bw.write("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            if(list.size() > 1 && (list.get(list.size()-1) == i && list.get(list.size()-2) == i)){
                continue;
            }
            list.add(i);
            count(list);
            list.remove(list.size()-1);
        }
    }
}