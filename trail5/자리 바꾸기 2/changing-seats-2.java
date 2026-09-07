import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[][] list = new int[K][2];
        ArrayList<HashSet<Integer>> set = new ArrayList<>();

        set.add(new HashSet<>());
        for(int i=1;i<=N;i++){
            arr[i] = i;
            set.add(new HashSet<>());
            set.get(i).add(i);
        }
        
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<K;j++){
                swap(list[j][0], list[j][1], arr);
                set.get(arr[list[j][0]]).add(list[j][0]);
                set.get(arr[list[j][1]]).add(list[j][1]);
            }
        }

        for(int i=1;i<=N;i++){
            bw.write(set.get(i).size()+"\n");
        }
        bw.flush();
    }
    static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}