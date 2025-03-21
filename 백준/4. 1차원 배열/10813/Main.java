import java.io.*;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[] basket = new int[N];

        for(int x=0;x<N;x++)
            basket[x]=x+1;

        for(int x=0;x<M;x++){
            String[] IJ = br.readLine().split(" ");
            int I = Integer.parseInt(IJ[0]);
            int J = Integer.parseInt(IJ[1]);

            int swap;
            swap = basket[I-1];
            basket[I-1] = basket[J-1];
            basket[J-1] = swap;

        }

        for(int x=0;x<N;x++)
            bw.write(basket[x]+" ");

        bw.write("\n");
        bw.flush();

    }
}
