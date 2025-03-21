import java.io.*;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++){
            String[] str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            System.out.println(A+B);
        }
    }
}
