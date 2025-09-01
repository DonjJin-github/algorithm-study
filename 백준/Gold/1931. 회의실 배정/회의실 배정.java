import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int count=1;
        int start = 0;
        int end = 0;
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0], b[0]);
            }
            else
                return Integer.compare(a[1], b[1]);
        });

        start = arr[0][0];
        end = arr[0][1];
        for(int i=1;i<N;i++){
            if(arr[i][0]<end)
                continue;
            else{
                count++;
                end = arr[i][1];
            }
        }
        bw.write(count+"\n");
        bw.flush();

    }
}