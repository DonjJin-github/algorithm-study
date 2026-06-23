import java.util.Scanner;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        printUp(1,n);
        bw.write("\n");
        printDown(n);
        bw.flush();
    }
    static void printUp(int x, int n)throws IOException{
        if(x==n+1)
            return;

        bw.write(x+" ");
        x++;
        printUp(x,n);
    }

    static void printDown(int n)throws IOException{
        if(n==0)
            return;

        bw.write(n+" ");
        n--;
        printDown(n);
    }
}