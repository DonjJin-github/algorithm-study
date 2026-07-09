import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cal(0, new ArrayList<>());

        bw.write(ans+"\n");
        bw.flush();
    }
    static void cal(int start, ArrayList<Integer> list){
        if(list.size() == M){
            int num = list.get(0);

            for(int i=1;i<M;i++){
                num ^= list.get(i);
            }
            ans = Math.max(ans,num);

            return;
        }

        for(int i=start;i<N;i++){
            list.add(arr[i]);
            cal(i+1, list);
            list.remove(list.size()-1);
        }
    }
}
