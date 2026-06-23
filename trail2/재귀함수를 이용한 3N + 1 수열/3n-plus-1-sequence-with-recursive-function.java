import java.util.Scanner;
public class Main {
static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        cal(n);
        System.out.print(ans);
    }
    static void cal(int n){
        if(n==1)
            return;

        ans++;

        if(n%2 == 0){
            cal(n/2);
        }
        else{
            cal(n*3+1);
        }

    }
}