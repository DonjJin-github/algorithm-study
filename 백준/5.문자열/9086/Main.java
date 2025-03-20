import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] str = new String[T];
        
        for(int i=0;i<T;i++){
            str[i]= br.readLine();
            bw.write(str[i].charAt(0)+""+str[i].charAt(str[i].length()-1)+"\n");
        }

        bw.flush();
    }
}
