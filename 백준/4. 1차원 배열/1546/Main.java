import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");

        float sum=0;
        int high=-1;
        float avg = 0;

        for(int i=0;i<N;i++){
            int temp = Integer.parseInt(str[i]);
            sum += temp;

            if(high<temp)
                high = temp;
        }

        sum = sum*100/high;
        avg = sum/N;

        bw.write(avg+"\n");
        bw.flush();


    }
}
