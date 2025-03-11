import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] remainder = new int[42];

        int cnt = 0;

        for(int i=0;i<10;i++){
            int num = Integer.parseInt(br.readLine());
            remainder[num%42]=1;
        }

        for(int i =0;i<42;i++){
            cnt += remainder[i];
        }

        bw.write(cnt+"\n");
        bw.flush();

    }
}
