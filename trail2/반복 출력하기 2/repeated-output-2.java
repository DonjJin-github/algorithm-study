import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        printHello(n);
        bw.flush();
    }

    static void printHello(int n) throws IOException {
        if(n==0)
            return;
        
        bw.write("HelloWorld\n");
        n--;

        printHello(n);
    }
}