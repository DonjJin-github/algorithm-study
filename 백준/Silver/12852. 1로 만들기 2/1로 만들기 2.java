import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        arr[1] = 0;
        if(n>1){
        arr[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            int temp = Integer.MAX_VALUE;
            arr[3] = 1;
            if (i % 3 == 0)
                temp = Math.min(arr[i / 3] + 1, temp);
            if (i % 2 == 0)
                temp = Math.min(arr[i / 2] + 1, temp);

            temp = Math.min(arr[i - 1] + 1, temp);
            arr[i] = temp;

        }
    }
        bw.write(arr[n] + "\n");
        int k = n;
        bw.write(k + " ");
        while (k != 1) {
            if (k%3==0 && arr[k] == arr[k / 3] + 1) {
                k = k / 3;
                bw.write(k + " ");
            }

            else if (k%2==0 && arr[k] == arr[k / 2] + 1) {
                k = k / 2;
                bw.write(k + " ");
            }

            else {
                k = k - 1;
                bw.write(k + " ");
            }

        }
        bw.flush();

    }
}