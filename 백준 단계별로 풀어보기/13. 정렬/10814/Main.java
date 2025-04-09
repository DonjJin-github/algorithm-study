import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[][] user = new String[N][2];

        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split(" ");
            user[i][0] = temp[0];
            user[i][1] = temp[1];
        }

        Arrays.sort(user,(a,b)->{
            return Integer.compare(Integer.parseInt(a[0]),Integer.parseInt(b[0]));
        });

        for(int i=0;i<N;i++)
            bw.write(user[i][0]+" "+user[i][1]+"\n");

        bw.flush();
    }
}
