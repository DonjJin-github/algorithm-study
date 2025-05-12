import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double sum = 0;
        int[] nums = new int[N];
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            nums[i] = temp;
            sum += temp;
            frequencyMap.put(temp, frequencyMap.getOrDefault(temp, 0) + 1);
        }

        int average = (int) (sum / N);

        Arrays.sort(nums);
        int median = nums[N / 2];

        int[][] num = new int[frequencyMap.size()][2];
        int j = 0;
        for (Integer key : frequencyMap.keySet()) {
            num[j][0] = key;
            num[j][1] = frequencyMap.get(key);
            j++;
        }

        Arrays.sort(num, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        int mode = num[0][0];
        if (num[0][1] == num[1][1]) {
            mode = num[1][0];
        }

        int range = nums[N - 1] - nums[0];

        bw.write(average + "\n");
        bw.write(median + "\n");
        bw.write(mode + "\n");
        bw.write(range + "\n");
        bw.flush();
    }
}
