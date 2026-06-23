import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        System.out.print(sum(n,0));
    }
    static int sum(int n, int ans){
        if(n==0)
            return ans;
        
        return sum(n-1, ans+n);
    }
}