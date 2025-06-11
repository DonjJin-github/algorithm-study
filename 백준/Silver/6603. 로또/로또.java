import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] printans = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if(k==0)
                break;

            arr = new int [k];

            for(int i=0;i<k;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            func(0, 0, k);
            bw.write("\n");
        }
        bw.flush();
    }
    static void func(int index,int count, int k)throws IOException{
        if(count==6){
            for(int i=0;i<6;i++)
                bw.write(printans[i]+" ");
            bw.write("\n");
            return;
        }

        for(int i=index;i<k;i++){
            printans[count] = arr[i];
            func(i+1,count+1, k);
        }
    }
}
