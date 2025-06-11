import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[] arr;
    static char[] printans;
    static int condition1 = 0;
    static int condition2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        printans = new char[L];
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<C;i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        func(0, 0, C, L);
        bw.flush();
    }

    static void func(int index, int count, int C, int L)throws IOException {
        if (count == L) {
            if (condition1 >= 1 && condition2 >= 2) {
                for (int i = 0; i < L; i++)
                    bw.write(printans[i]);
                bw.write("\n");
            }
            return;
        }

        for (int i = index; i < C; i++) {
            printans[count] = arr[i];
            switch (printans[count]) {
                case 'a':
                    condition1++;
                    break;
                case 'e':
                    condition1++;
                    break;
                case 'i':
                    condition1++;
                    break;
                case 'o':
                    condition1++;
                    break;
                case 'u':
                    condition1++;
                    break;
                default:
                    condition2++;
                    break;
            }
            func(i + 1, count + 1, C, L);
            switch (printans[count]) {
                case 'a':
                    condition1--;
                    break;
                case 'e':
                    condition1--;
                    break;
                case 'i':
                    condition1--;
                    break;
                case 'o':
                    condition1--;
                    break;
                case 'u':
                    condition1--;
                    break;
                default:
                    condition2--;
                    break;
            }
        }
    }
}
