import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = 0;

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken())+arr[i-1];
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken())-2;
            end = Integer.parseInt(st.nextToken())-1;
            if(start<0)
                bw.write(arr[end]+"\n");
            else
                bw.write(arr[end]-arr[start]+"\n");
        }

        bw.flush();

    }
}
