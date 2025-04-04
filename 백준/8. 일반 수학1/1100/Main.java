import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] NB = br.readLine().split(" ");

        int N = Integer.parseInt(NB[0]);
        int B = Integer.parseInt(NB[1]);
        int num=N;
        char c;
        int k;

        while(num>B){
            num = num/B;
            int temp = N % B;

            if(temp>=10){
                int x = 'A'+temp-10;
                bw.write(x);
            }
            else if(temp<10){
                k = temp;
                bw.write(k+"");
            }
        }
        bw.flush();
    }
}
