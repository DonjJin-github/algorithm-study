import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String[] str2 = br.readLine().split("");

        int a = Integer.parseInt(str1);
        int b = Integer.parseInt(str2[0]);
        int c = Integer.parseInt(str2[1]);
        int d = Integer.parseInt(str2[2]);

        System.out.println(a*d);
        System.out.println(a*c);
        System.out.println(a*b);
        System.out.println(a*d+a*c*10+a*b*100);

        



    }
}
