import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<int[]> boomdx = new ArrayList<>();
    static ArrayList<int[]> boomdy = new ArrayList<>();
    static int boom = 0;
    static int count = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        boomdx.add(new int[]{-2, -1, 1, 2});
        boomdy.add(new int[]{0, 0, 0, 0});
        boomdx.add(new int[]{-1, 0, 1, 0});
        boomdy.add(new int[]{0, 1, 0, -1});
        boomdx.add(new int[]{-1, -1, 1, 1});
        boomdy.add(new int[]{-1, 1, 1, -1});
        
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1)
                    list.add(new int[]{i,j});
            }
        }

        backtracking(n,list.size(),0,0);
        bw.write(max+list.size()+"");
        bw.flush();
    }
    static void backtracking(int n, int size, int start, int depth){
        if(depth == size){
            max = Math.max(max, boom);
            return;
        }


        for(int k = start; k<list.size(); k++){
            int x = list.get(k)[0];
            int y = list.get(k)[1];
            for(int i=0;i<3;i++){
                ArrayList<int[]> temp = new ArrayList<>();
                int tempBoom = 0;
                for(int j=0;j<4;j++){
                    int nx = x + boomdx.get(i)[j];
                    int ny = y + boomdy.get(i)[j];

                    if(nx < 0 || nx >= n || ny<0 || ny>=n)
                        continue;
                    
                    if(arr[nx][ny] != 0)
                        continue;

                    arr[nx][ny] = 2;
                    boom++;
                    tempBoom++;
                    temp.add(new int[]{nx,ny});
                }
                backtracking(n, size, k+1,depth+1);
                boom-=tempBoom;
                for(int[] t : temp){
                    arr[t[0]][t[1]] = 0;
                }
            }
        }
    }
}
