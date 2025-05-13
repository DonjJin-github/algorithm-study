import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringBuilder sb;
        while ((str = br.readLine())!=null) {
            sb = new StringBuilder();

            int temp =(int) Math.pow(3, Integer.parseInt(str));
            
            for(int i=0;i<temp;i++)
                sb.append("-");

            divide(sb,0,temp);
            System.out.println(sb);
        }
    }

    public static void divide(StringBuilder sb, int start, int len) {
        if (len == 1) return;
    
        int third = len / 3;
    
        for (int i = start + third; i < start + 2 * third; i++) {
            sb.setCharAt(i, ' ');
        }
    
        divide(sb, start, third);
        divide(sb, start + 2 * third, third);
    }
}
