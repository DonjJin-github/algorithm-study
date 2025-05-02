import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<Integer> list = new HashSet<>();
        
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");
        int count =0;

        for(int i =0;i<N;i++){
            int temp = Integer.parseInt(A[i]);
            list.add(temp);
        }
        
        for(int i =0;i<M;i++){
            int temp = Integer.parseInt(B[i]);
            if (list.contains(temp)) 
                count++;
        }
        bw.write(N+M-(2*count)+"\n");
        bw.flush();
    }
}
