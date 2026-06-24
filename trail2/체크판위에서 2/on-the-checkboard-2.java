import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        // Please write your code here.
        Queue<int[]> q = new ArrayDeque<>();

        int ans = 0;
        q.add(new int[]{0,0,0});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int jump = temp[2];

            if(jump==3 && x==R-1 && y==C-1){
                ans++;
                continue;
            }

            for(int i=x+1;i<R;i++){
                for(int j=y+1;j<C;j++){
                    if(grid[x][y]=='W'){
                        if(grid[i][j] == 'B'){
                            q.add(new int[]{i,j,jump+1});
                        }
                    }
                    else{
                        if(grid[i][j] == 'W'){
                            q.add(new int[]{i,j,jump+1});
                        }
                    }
                }
            }
        }

        System.out.print(ans);
    }
}