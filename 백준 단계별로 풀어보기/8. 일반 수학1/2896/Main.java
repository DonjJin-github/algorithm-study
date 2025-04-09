import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ABV = br.readLine().split(" ");

        int A = Integer.parseInt(ABV[0]);
        int B = Integer.parseInt(ABV[1]);
        int V = Integer.parseInt(ABV[2]);

        int date = 1;
        int distance = A;

        date = (V-A)/(A-B);
        distance += date*(A-B);

        if(distance>=V)
            date++;
        else
            date+=2;

        bw.write(date+"\n");
        bw.flush();
    }
}
