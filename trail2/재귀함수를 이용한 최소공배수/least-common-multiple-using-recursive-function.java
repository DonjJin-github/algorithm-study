import java.util.Scanner;

public class Main {
    static int ans = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        if(n == 1){
            System.out.print(arr[0]);
        }else{
            int temp = arr[0] / gcd(arr[0],arr[1]) * arr[1];
            for(int i=1;i<n;i++){
                int k = temp;
                temp =  k / gcd(k,arr[i]) * arr[i];
            }
            System.out.print(temp);
        }
    }
    static int gcd(int a, int b){
        if(b==0)
            return a;

        return gcd(b, a%b);
    }
}