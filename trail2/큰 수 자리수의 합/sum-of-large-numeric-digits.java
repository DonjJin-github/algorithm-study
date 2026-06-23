import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.
        System.out.print(sum(a*b*c));
    }
    static int sum (long n){
        if(n == 0)
            return 0;
        
        int temp = (int)(n%10L);
        
        return temp + sum(n/10);
    }
}