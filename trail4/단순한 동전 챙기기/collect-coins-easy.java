import java.util.*;
import java.io.*;

public class Main {
    static final int start = 100000;
    static final int end = 100001;
    static boolean[] visit;
    static int N;
    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    
    static ArrayList<int[]> coin = new ArrayList<>();
    static int[][] SE = new int[2][2];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split("");
            for(int j=0;j<N;j++){
                if(temp[j].equals("S")){
                    arr[i][j] = start;
                    SE[0][0] = i;
                    SE[0][1] = j;
                }
                else if(temp[j].equals("E")){
                    arr[i][j] = end;
                    SE[1][0] = i;
                    SE[1][1] = j;
                }
                else if(!temp[j].equals(".")){
                    arr[i][j] = Integer.parseInt(temp[j]);
                    coin.add(new int[]{i,j});
                }
            }
        }

        visit = new boolean[coin.size()];
        getCoin(0, new int[]{SE[0][0], SE[0][1]}, new ArrayList<>(), 0);
        if(ans == Integer.MAX_VALUE)
            bw.write(-1+"\n");
        else
            bw.write(ans+"\n");
        bw.flush();
    }
    static void getCoin(int idx, int[] cur, ArrayList<int[]> get, int distance){
        if(get.size()>=3){
            int d = distance + Math.abs(SE[1][0] - cur[0]) + Math.abs(SE[1][1] - cur[1]);
            ans = Math.min(ans,d);
        }

        for(int i=0;i<coin.size();i++){
            if(visit[i])
                continue;
            
            visit[i] = true;
            int temp[] = {coin.get(i)[0], coin.get(i)[1]};
            int d = Math.abs(temp[0] - cur[0]) + Math.abs(temp[1] - cur[1]);

            if(arr[cur[0]][cur[1]] == start){
                get.add(new int[]{temp[0],temp[1]});
                distance += d;
                getCoin(i+1, new int[]{temp[0],temp[1]}, get , distance);
                get.remove(get.size()-1);
                distance -= d;
            }
            else if(arr[cur[0]][cur[1]] < arr[temp[0]][temp[1]]){
                get.add(new int[]{temp[0],temp[1]});
                distance += d;
                getCoin(i+1, new int[]{temp[0],temp[1]}, get, distance);
                get.remove(get.size()-1);
                distance -= d;
            }
            visit[i] = false;
        }
    }
}