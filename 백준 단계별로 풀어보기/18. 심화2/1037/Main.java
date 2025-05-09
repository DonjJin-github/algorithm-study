import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];

        for(int i =0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        if(N==1)
            bw.write(num[0]*num[0]+"\n");
        else
            bw.write(num[0]*num[N-1]+"\n");


        bw.flush();
    }
}
