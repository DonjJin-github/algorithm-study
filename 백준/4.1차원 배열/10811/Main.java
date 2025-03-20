import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] basket = new int[N];
        int[] reverse = new int[N];

        for(int x=0; x<N;x++)
            basket[x]=x+1;

        for(int x=0;x<M;x++){
            String[] ij = br.readLine().split(" ");
            int i = Integer.parseInt(ij[0]);
            int j = Integer.parseInt(ij[1]);
            int temp = j-1;

            for(int k=i-1;k<j; k++){
                reverse[k] = basket[temp];
                temp--;
            }

            for(int k=i-1;k<j; k++){
                basket[k]=reverse[k];
            }

        }

        for(int i=0;i<N;i++){
            bw.write(basket[i]+" ");
        }

        bw.flush();


    }
}
