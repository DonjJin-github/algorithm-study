import java.io.*;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int H = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        if(M-45<0){
            if(H==0)
                System.out.println("23 "+(M+15));
            else
                System.out.println((H-1)+" "+(M+15));
        }
        else
            System.out.println(H+" "+(M-45));


    }
    
}
