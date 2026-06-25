import java.util.*;
import java.io.*;

public class Main {
    static int[] list;
    static int check = 0;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());     
        list = new int[5];

        for(int i=1;i<=4;i++){
            list[i] = i;
        }
        backtracking(N);
        bw.write(x+"");
        bw.flush();

    }
    static void backtracking(int N){
        if(check == N){
            x++;
            return;
        }
        if(check >N)
            return;

        for(int i=1;i<=4;i++){
            check+=list[i];
            backtracking(N);
            check-=list[i];
        }
            
    }
}