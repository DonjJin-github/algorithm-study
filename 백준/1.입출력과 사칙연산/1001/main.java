import java.io.*;


public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int[] num = new int[str.length];

        num[0] = Integer.parseInt(str[0]);
        num[1] = Integer.parseInt(str[1]);

        System.out.println(num[0]-num[1]);

    }
}
