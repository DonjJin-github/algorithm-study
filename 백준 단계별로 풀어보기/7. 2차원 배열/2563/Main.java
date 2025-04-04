import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] square = new int[100][100];
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++){
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0])-1;
            int y = Integer.parseInt(xy[1])-1;

            for(int k=x;k<x+10;k++)
                for(int j=y;j<y+10;j++)
                    square[k][j] = 1;
        }

        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++)
                if(square[i][j]==1)
                    count++;
        }

        bw.write(count+"\n");
        bw.flush();
    }
}
