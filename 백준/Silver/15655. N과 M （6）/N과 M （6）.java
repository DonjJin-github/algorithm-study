import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int [] arr;
    static boolean [] isused;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isused = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func(0,0, N, M);
        bw.flush();

    }
    static void func(int index,int count, int N, int M)throws IOException{
        if(count==M){
            for(int i =0;i<N; i++){
                if(isused[i])
                    bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return ;
        }

        for(int i=index;i<N;i++){
            if(!isused[i]){
                isused[i] = true;
                func(i+1,count+1, N, M);
                isused[i] = false;
            }
        }
    }
}
