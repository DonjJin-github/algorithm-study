import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int ans = 0;

        int[] count = new int[10000];
        
        for(int i=0;i<10000;i++){
            count[i]=i+1;
            ans+=count[i];
            if(X>ans)
                continue;
            else if(X<=ans){
                if(i%2!=0){
                    int temp =count[i]-(ans-X);
                    bw.write(temp+"/"+(i+2-temp));
                    break;
                }
                else{
                    int temp =count[i]-(ans-X);
                    bw.write((i+2-temp)+"/"+temp);
                    break;
                }
            }
        }
        bw.flush();
    }
}