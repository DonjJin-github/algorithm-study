import java.io.*;

public class Main{
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static int recursion(String s, int l, int r){
        if(l >= r){
            count++;
            return 1;
        } 
        else if(s.charAt(l) != s.charAt(r)){
            count++;
            return 0;
        }
        else {
            count++;
            return recursion(s, l+1, r-1);
        }
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i =0;i<N;i++){
            count = 0;
            bw.write(isPalindrome(br.readLine())+" "+count+"\n");
        }
        
        bw.flush();
    }
}