import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num=665;
        int check = 0;
        int ans = 0;
        while(true){
            num++;
            int temp = num;
            while(temp>1){
                if(temp%10 == 6){
                    temp = temp/10;
                    if(temp%10==6){
                        temp = temp/10;
                        if(temp%10==6)
                            check++;
                    }
                }
                temp = temp/10;
            }

            if(check>=1)
                ans++;
            if(ans==N)
                break;
            else
                check=0;
        }
        bw.write(num+"\n");
        bw.flush();
    }
}
