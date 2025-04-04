import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NB = br.readLine().split(" ");
        int N = Integer.parseInt(NB[0]);  
        int B = Integer.parseInt(NB[1]);  

        StringBuilder result = new StringBuilder();

        while (N > 0) {
            int remainder = N % B;  
            N = N / B; 

            if (remainder >= 10) {
                result.append((char) ('A' + remainder - 10));
            } else {
                result.append(remainder);
            }
        }

        bw.write(result.reverse().toString());
        bw.flush();
    }
}
