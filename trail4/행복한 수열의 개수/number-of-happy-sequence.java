import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int ans = 0;
        for(int i=0;i<N;i++){
            int k = -1;
            int count = 0;
            for(int j=0;j<N;j++){
                if(k == arr[i][j])
                    count++;
                else{
                    k = arr[i][j];
                    count = 1;
                }
                if(count>=M){
                    ans++;
                    break;
                }
            }
        }
        for(int i=0;i<N;i++){
            int k = -1;
            int count = 0;
            for(int j=0;j<N;j++){
                if(k == arr[j][i])
                    count++;
                else{
                    k = arr[j][i];
                    count = 1;
                }
                if(count>=M){
                    ans++;
                    break;
                }
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}