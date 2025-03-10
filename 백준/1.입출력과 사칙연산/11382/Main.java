import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        Long a = Long.parseLong(str[0]);
        Long b = Long.parseLong(str[1]);
        Long c = Long.parseLong(str[2]);

        System.out.println(a+b+c);
    }
}
