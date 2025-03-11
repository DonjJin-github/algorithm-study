import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[9];
        int index = 0;
        int max = -1;
        for(int i=0;i<9;i++){
            a[i] = Integer.parseInt(br.readLine());

            max = Math.max(max,a[i]);
            if(max==a[i])
                index = i+1;
        }

        bw.write(max+"\n"+index+"\n");
        bw.flush();
        
    }
}
