import java.io.*;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int C = Integer.parseInt(br.readLine());

        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);

        if(B+C>=60){
            A+=(B+C)/60;
            B = (B+C)%60;
            if(A>23)
                A = A%24;
            System.out.println(A+" "+B);
        }
        else
            System.out.println(A+" "+(B+C));       
    }
    
}
