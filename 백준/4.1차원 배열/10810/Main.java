import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] basket = new int[N];

        for(int x=0; x<M; x++){
            String[] str = br.readLine().split(" ");
            int i = Integer.parseInt(str[0]);
            int j = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);

            for(int y=i-1;y<j;y++){
                basket[y]=k;
            }
        }

        for(int x=0; x<N;x++)
            bw.write(basket[x]+" ");

        bw.write("\n");
        bw.flush();
    }
}
