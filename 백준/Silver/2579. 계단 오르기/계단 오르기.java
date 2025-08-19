import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int dis[][] = new int[n][2];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n==1){
            bw.write(arr[0]+"\n");
            bw.flush();
            return;
        }
        if(n==2){
            bw.write(arr[0]+arr[1]+"\n");
            bw.flush();
            return;
        }

        dis[0][0] = arr[0];
        dis[0][1] = arr[0];

        dis[1][0] = arr[1];
        dis[1][1] = arr[1] + arr[0];

        for (int i = 2; i < n; i++) {
            dis[i][0] = arr[i] + Math.max(dis[i - 2][0], dis[i - 2][1]);
            dis[i][1] = arr[i] + dis[i - 1][0]; 
        }

        bw.write(Math.max(dis[n - 1][0], dis[n - 1][1]) + "\n");
        bw.flush();
    }
}
