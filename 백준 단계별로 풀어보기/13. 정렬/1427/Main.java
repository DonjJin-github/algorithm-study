import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        Integer[] arr =new Integer[str.length];

        for(int i=0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(arr,Collections.reverseOrder());

        for(int i=0;i<str.length;i++)
            bw.write(arr[i]+"");
        
        bw.write("\n");
        bw.flush();
    }
}
