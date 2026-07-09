import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int dist;
    static int ans = Integer.MAX_VALUE;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        choose(0, new ArrayList<>());
        bw.write(ans + "\n");
        bw.flush();
        
    }
    static void choose(int idx, ArrayList<int[]> list){
        if(idx >= N){
            if(list.size() == M){
                dist = 0;
                cal(0, new ArrayList<>(), list);
                ans = Math.min(dist,ans);
                return;
            }   
            return;
        }
      

        list.add(new int[]{arr[idx][0], arr[idx][1]});
        choose(idx+1, list);
        list.remove(list.size()-1);

        choose(idx+1, list);
    }

    static void cal(int idx, ArrayList<Integer> k, ArrayList<int[]> list){
        if(idx >= list.size()){
            if(k.size() == 2){
                int x1 = list.get(k.get(0))[0];
                int y1 = list.get(k.get(0))[1];
                int x2 = list.get(k.get(1))[0];
                int y2 = list.get(k.get(1))[1];

                int num1 = (int)Math.pow((x1-x2),2);
                int num2 = (int)Math.pow((y1-y2),2);
                
                dist = Math.max(num1+num2,dist);
                return;
            }
            return;
        }
        
        k.add(idx);
        cal(idx+1, k, list);
        k.remove(k.size()-1);

        cal(idx+1, k, list);
    }
}