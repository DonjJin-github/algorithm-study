import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        String sCode = str[0];
        char mPoint = str[1].charAt(0);
        int time = Integer.parseInt(str[2]);

        bw.write("secret code : "+sCode+"\n");
        bw.write("meeting point : "+mPoint+"\n");
        bw.write("time : "+time+"\n");
        bw.flush();
    }
}