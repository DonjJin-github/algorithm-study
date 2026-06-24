import java.util.*;
import java.io.*;

public class Main {
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    static int[] raser1dx = {0, -1, 0, 1};
    static int[] raser1dy = {1, 0, -1, 0};
    static int[] raser1Dir = {RIGHT, UP, LEFT, DOWN};

    static int[] raser2dx = {0, 1, 0, -1};
    static int[] raser2dy = {-1, 0, 1, 0};
    static int[] raser2Dir = {LEFT, DOWN, RIGHT, UP};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split("");
                for(int j=0;j<N;j++){
                arr[i][j] = temp[j].charAt(0);
            }
        }
        int K = Integer.parseInt(br.readLine());
        
        int x = -1;
        int y = 0;
        int dir = 0;
        for(int i=1;i<=4*N;i++){
            if(i==K)
                break;
            if(i<=N){
                y++;
                dir = DOWN;
                if(i==N){
                    x++;
                    dir=LEFT;
                }
            }
            else if(i>N && i<=2*N){
                x++;
                dir = LEFT;
                if(i==2*N){
                    y--;
                    dir = UP;
                }
            }
            else if(i>2*N && i<=3*N){
                y--;
                dir = UP;
                if(i==3*N){
                    x--;
                    dir = RIGHT;
                }
            }
            else if(i>3*N && i<=4*N){
                x--;
                dir = RIGHT;
            }
        }

        int ans = 0;
        if(dir==UP){
            x--;
        }
        else if (dir == RIGHT){
            y++;
        }
        else if(dir == LEFT){
            y--;
        }else{
            x++;
        }

        while(true){
            if(arr[x][y]=='/'){
                x += raser1dx[dir];
                y += raser1dy[dir];
                dir = raser1Dir[dir];
                ans++;
                if(x <0 || x>=N || y<0 || y>=N)
                    break;
            }
            else{
                x += raser2dx[dir];
                y += raser2dy[dir];
                dir = raser2Dir[dir];
                ans++;
                if(x <0 || x>=N || y<0 || y>=N)
                    break;
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}