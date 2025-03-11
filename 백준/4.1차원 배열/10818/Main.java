import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int[] A = new int[N];

        for(int i = 0;i<N;i++)
            A[i] = Integer.parseInt(str[i]);

        Arrays.sort(A);

        bw.write(A[0]+" "+A[N-1]);
        bw.flush();
        
    }
}
