import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int num1 = 0;
        int num2 = 0;
        boolean check = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '-') {
                if (check)
                    num1 += Integer.parseInt(sb.toString());
                else
                    num2 += Integer.parseInt(sb.toString());
                sb = new StringBuilder(); 
                check = true;
            } else if (line.charAt(i) == '+') {
                if (check)
                    num1 += Integer.parseInt(sb.toString());
                else
                    num2 += Integer.parseInt(sb.toString());
                sb = new StringBuilder(); 
            } else {
                sb.append(line.charAt(i));
            }
        }

        if (check)
            num1 += Integer.parseInt(sb.toString());
        else
            num2 += Integer.parseInt(sb.toString());
        
        bw.write(num2-num1+"\n");
        bw.flush();

    }
}
