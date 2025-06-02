import java.io.*;

public class Main {
    static boolean col[];
    static int count = 0;
    static boolean diag1[];
    static boolean diag2[];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        diag1 = new boolean[2*N-1];
        diag2= new boolean[2*N-1];
        Nqueen(0, N);
        bw.write(count+"\n");
        bw.flush();
    }

    static void Nqueen(int row, int N){
        if(row==N){
            count++;
            return;
        }

        for(int i=0;i<N;i++){
            if(col[i]||diag1[row+i]||diag2[row-i+N-1]){
                continue;
            }
            col[i] = true;
            diag1[row+i]=true;
            diag2[row-i+N-1]=true;
            Nqueen(row+1, N);
            col[i] = false;
            diag1[row+i]=false;
            diag2[row-i+N-1]=false;
        }
    }
    
}
