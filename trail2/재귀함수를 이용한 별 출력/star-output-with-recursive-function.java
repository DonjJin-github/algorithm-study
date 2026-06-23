import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        printStar(1, n);
        bw.flush();

    }
    static void printStar(int t, int n)throws IOException{
        if(t==n+1)
            return;
        
        for(int i=0;i<t;i++)
            bw.write("*");
        t++;
        bw.write("\n");
        printStar(t,n);
    }
}