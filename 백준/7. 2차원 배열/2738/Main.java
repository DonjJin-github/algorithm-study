import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] array = new int[N][M];

        for(int k=0;k<2;k++){
            for(int i =0; i<N;i++){
                String[] temp = br.readLine().split(" ");
                for(int j=0; j<M;j++){
                    array[i][j] += Integer.parseInt(temp[j]);
                }
            }
        }

        for(int i =0; i<N;i++){
            for(int j=0; j<M;j++){
                bw.write(array[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();

    }
}
