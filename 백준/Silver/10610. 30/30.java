import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split("");
        int[] num = new int[temp.length];
        int zcount = 0;
        int sum = 0;

        for(int i=0;i<temp.length;i++){
            num[i] = Integer.parseInt(temp[i]);
            if(num[i]==0)
                zcount++;
            sum += num[i];
        }
        Arrays.sort(num);

        if(sum%3==0 && zcount >0){
            for(int i=num.length-1;i>=0;i--){
                bw.write(num[i]+"");
            }
            bw.write("\n");
        }
        else
            bw.write("-1\n");

        bw.flush();

    }
}