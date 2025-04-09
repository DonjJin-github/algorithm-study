import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] x =new int [N][2];
        int ans[][] = new int[N][2];

        String[] temp = br.readLine().split(" ");
        int count = 0;

        for(int i=0;i<N;i++){
            x[i][0] = Integer.parseInt(temp[i]);
            x[i][1] = i+1;
        }

        Arrays.sort(x,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });

        ans[0][1] = x[0][1];
        for(int i = 1;i<N;i++){
            ans[i][1]=x[i][1];
            if(x[i][0]==x[i-1][0]){
                ans[i][0] = count;
                continue;
            }
            count++;
            ans[i][0]=count;
            
        }
        Arrays.sort(ans,(a,b)->{
            return Integer.compare(a[1],b[1]);
        });

        for(int i=0;i<N;i++)
            bw.write(ans[i][0]+" ");
        bw.write("\n");
        bw.flush();
    }
}
