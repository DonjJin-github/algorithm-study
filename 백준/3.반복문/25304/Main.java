import java.io.*;
public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int price = 0;
        for(int i = 0; i<N; i++){   
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            price += a*b;
        }
        if(price == X)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    
}
