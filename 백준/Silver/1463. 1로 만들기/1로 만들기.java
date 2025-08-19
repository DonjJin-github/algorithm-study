import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int x, y, z;

        int arr[] = new int[n + 1];

        arr[0] = 0;
        arr[1] = 0;
        if (n == 1) {
            bw.write("0\n");
            bw.flush();
            return;
        }
        arr[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            x = Integer.MAX_VALUE;
            y = Integer.MAX_VALUE;
            if (i % 3 == 0)
                x = arr[i / 3] + 1;
            if (i % 2 == 0)
                y = arr[i / 2] + 1;
            z = arr[i - 1] + 1;
            x = Math.min(x, y);
            arr[i] = Math.min(x, z);
        }
        bw.write(arr[n] + "\n");
        bw.flush();
    }
}
