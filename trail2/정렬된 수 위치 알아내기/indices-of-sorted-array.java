import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[n];
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = i+1;
        }
        // Please write your code here.
        Arrays.sort(arr, (a,b)->{
            if(a[0]==b[0])
                return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        for(int i=0;i<n;i++){
            ans[arr[i][1]-1] = i+1;
        }

        for(int i=0;i<n;i++){
            bw.write(ans[i]+" ");
        }
        bw.flush();
    }
}