import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        print(n);
        bw.flush();
    }
    static void print(int n) throws IOException {
        if(n==0)
            return;
        bw.write(n+" ");
        print(n-1);
        bw.write(n+" ");
    }
}