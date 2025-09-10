import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int t = 0;t<N;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int arr[] = new int[len];
            long ans = 0;

            for(int i=0;i<len;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<len;i++){
                for(int j=i+1;j<len;j++){
                        ans += gcd(arr[i],arr[j]);
                }
            }
            bw.write(ans+"\n");
        }

        bw.flush();

    }

    public static int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
