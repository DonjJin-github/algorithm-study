import java.io.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        float ans =0;
        int sum=0;
        for(int i=0;i<20;i++){
            String[] str = br.readLine().split(" ");

            float num = Float.parseFloat(str[1]);
            String grade = str[2];
            sum+=num;
            switch (grade) {
                case "A+":
                    ans += num*4.5;
                    break;
                case "A0":
                    ans += num*4.0;
                    break;
                case "B+":
                    ans += num*3.5;
                    break;
                case "B0":
                    ans += num*3.0;
                    break;
                case "C+":
                    ans += num*2.5;
                    break;
                case "C0":
                    ans += num*2.0;
                    break;
                case "D+":
                    ans += num*1.5;
                    break;
                case "D0":
                    ans += num*1.0;
                    break;
                case "F":
                    ans += num*0;
                    break;
            
                default:
                    sum-=num;
                    break;
            }
        }
        bw.write(ans/sum+"\n");
        bw.flush();

    }
}
