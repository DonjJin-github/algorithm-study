import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dir;
    static int[] dx = {-10, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {-10, 0, 1, 1, 1, 0, -1, -1, -1};
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dir = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                dir[i][j] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        count(x-1,y-1, new ArrayList<>());
        bw.write(ans+"\n");
        bw.flush();
    }
    static void count(int x, int y, ArrayList<Integer> list){

        int nx = x;
        int ny = y;

        while(true){
            nx += dx[dir[x][y]];
            ny += dy[dir[x][y]];

            if(nx <0 || nx>=N || ny<0 || ny>=N){
                ans = Math.max(ans,list.size());
                break;       
            }
            
            if(arr[nx][ny]>arr[x][y]){
                list.add(arr[nx][ny]);
                count(nx, ny, list);
                list.remove(list.size()-1);
            }
            else{
                ans = Math.max(ans,list.size());
            }
        }
    }
}