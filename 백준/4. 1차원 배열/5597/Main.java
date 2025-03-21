import java.io.*;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] submit = new int[30];

        for(int i=0;i<28;i++){
            int check = Integer.parseInt(br.readLine());
            submit[check-1] = 1;
        }

        for(int i=0;i<30;i++){
            if(submit[i]==0)
                bw.write((i+1)+"\n");
        }

        bw.flush();
            
    }
}
