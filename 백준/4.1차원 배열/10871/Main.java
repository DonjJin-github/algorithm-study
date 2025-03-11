import java.io.*;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NX = br.readLine().split(" ");
        int N = Integer.parseInt(NX[0]);
        int X = Integer.parseInt(NX[1]);

        String[] str = br.readLine().split(" ");
        
        for(int i=0;i<N;i++){
            int A = Integer.parseInt(str[i]);

            if(A<X)
                bw.write(A+" ");
        }
        bw.write("\n");

        bw.flush();
    }
}
