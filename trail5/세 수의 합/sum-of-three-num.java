import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }   
        
        int answer = 0;
        for(int i=0;i<N;i++){
            int x = arr[i];

            int k = K-x;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<i;j++){
                int y = arr[j];
                answer += map.getOrDefault(k-y, 0);
                map.put(y, map.getOrDefault(y,0)+1);
            }
        }   

        bw.write(answer+"\n");
        bw.flush();
    }
}