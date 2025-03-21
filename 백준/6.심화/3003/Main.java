import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int[] co = {1,1,2,2,2,8};
        for(int i = 0; i<6;i++){
            int ans = co[i]-Integer.parseInt(str[i]);
            bw.write(ans+" ");
        }
        bw.write("\n");
        bw.flush();
    }
}
