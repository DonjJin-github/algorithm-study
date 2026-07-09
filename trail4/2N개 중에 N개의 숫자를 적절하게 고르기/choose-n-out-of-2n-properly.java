import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int ans = Integer.MAX_VALUE;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[2*N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        
        min(0, new ArrayList<>());
        bw.write(ans + "\n");
        bw.flush();
    }
    static void min(int idx, ArrayList<Integer> list){
        if(idx>=2*N){
            if(list.size() == N){
                int num1 = 0;
                int num2 = 0;
                
                for(int temp : list)
                    num1 += temp;
                num2 = sum - num1;

                ans = Math.min(ans, Math.abs(num1-num2));
            }
            return;
        }

        list.add(arr[idx]);
        min(idx+1, list);
        list.remove(list.size()-1);

        min(idx+1,list);
    }
}
