import java.io.*;

public class Main {
    public static void main(String argsp[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int score = Integer.parseInt(br.readLine());

        if(score<=100&&90<=score)
            System.out.println("A");
        else if(score<=89&&80<=score)
            System.out.println("B");
        else if(score<=79&&70<=score)
            System.out.println("C");
        else if(score<=69&&60<=score)
            System.out.println("D");    
        else
            System.out.println("F");

    }
    
}
