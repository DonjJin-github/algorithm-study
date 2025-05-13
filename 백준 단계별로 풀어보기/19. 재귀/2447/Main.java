import java.io.*;

public class Main {
    static char[][] a;
    static int N ;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        a = new char[N][N];

        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                a[i][j] = '*';

        star(0,0,N);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                bw.write(a[i][j]);
            bw.write("\n");
        }
        bw.flush();
    }
    public static void star(int startx, int starty, int len){
        int index = len/3;

        if(index<1)
            return;
        if(startx+index>=N||starty+index>=N)
            return;
        for(int i=startx+index;i<startx+2*index;i++){
            for(int j=starty+index;j<starty+2*index;j++)
                a[i][j] = ' ';
        }

        for (int i = startx; i < startx + len; i += index) {
            for (int j = starty; j < starty + len; j += index) {
                star(i, j, index);
            }
        }
    }
}
