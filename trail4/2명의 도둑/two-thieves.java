import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int N;
    static int M;
    static int C;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,0,new ArrayList<int[]>());
        bw.write(ans+"\n");
        bw.flush();
    }
    static void backtracking(int depth, int start, ArrayList<int[]> list){
        if(depth == 2){
            int temp = maxValue(list.get(0)) + maxValue(list.get(1));
            ans = Math.max(ans, temp);
            return;
        }

        for(int i = start; i < N; i++){
            for(int j = 0; j <= N - M; j++){
                if(depth!=0){
                    int x = list.get(depth-1)[0];
                    int y = list.get(depth-1)[1];

                    if(x==i){
                        if((j + M > y) && (y + M > j))
                            continue;
                    }
                }

                list.add(new int[]{i, j});
                backtracking(depth + 1, i, list);
                list.remove(list.size() - 1);
            }
        }
    }
    static int maxValue(int[] item){
        int x = item[0];
        int y = item[1];
        int bag[] = new int[M+1];

        for(int i=1;i<=M;i++){
            bag[i] = arr[x][y+i-1];
        }
        int[][] dp = new int[M+1][C+1];

        for(int i=1;i<=M;i++){
            for(int j=0;j<=C;j++){
                if(j>=bag[i]){
                    int value = bag[i]*bag[i];
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-bag[i]]+value);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[M][C];
    }
}
