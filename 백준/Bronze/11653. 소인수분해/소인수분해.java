import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 2; i*i<=num;i++){
            while (num%i==0) {
                num = num/i;
                bw.write(i+"\n");
            }
        }

        if(num!=1)
            bw.write(num+"\n");

        bw.flush();
    }
}
