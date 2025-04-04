import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NB = br.readLine().split(" ");

        String N = NB[0];
        int B = Integer.parseInt(NB[1]);
        int ans = 0;

        if(B>10){
            int num = N.length()-1;
            for(int i =0;i<N.length();i++){
                int k = N.charAt(i);
                if((k-48)<11)
                    k = N.charAt(i)-48;
                else
                    k = N.charAt(i)-'A'+10;
                ans += Math.pow(B,num)*k;
                num--;
            }
            bw.write(ans+"\n");
        }
        else if(B == 10)
            bw.write(N+"\n");
        else{
            int num = N.length()-1;
            for(int i =0;i<N.length();i++){
                int k = N.charAt(i)-48;
                ans += Math.pow(B,num)*k;
                num--;
            }
            bw.write(ans+"\n");
        }
        bw.flush();
    }
}
