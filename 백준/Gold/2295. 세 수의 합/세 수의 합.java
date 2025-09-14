import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        HashSet<Integer> list = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++)
                list.add(arr[i] + arr[j]);
        }


        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (list.contains(arr[i] - arr[j])) {
                    bw.write(arr[i] + "\n");
                    bw.flush();
                    return;
                }
            }
        }

    }
}
