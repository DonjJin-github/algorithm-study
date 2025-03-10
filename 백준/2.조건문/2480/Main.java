import java.io.*;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int[] num = new int[str.length];
        
        for(int i =0;i<str.length;i++)
            num[i] = Integer.parseInt(str[i]);
        
        if(num[0]==num[1]&&num[0]==num[2])
            System.out.println(10000+num[0]*1000);
        else if(num[0]==num[1]||num[0]==num[2])
            System.out.println(1000+num[0]*100);
        else if(num[1]==num[2])
            System.out.println(1000+num[2]*100);
        else{
            if(num[1]>num[0]){
                if(num[1]>num[2])
                    System.out.println(num[1]*100);
                else
                    System.out.println(num[2]*100);
            }            
            else{
                if(num[0]>num[2])
                    System.out.println(num[0]*100);
                else
                    System.out.println(num[2]*100);
            }
        }
        
    }
}
