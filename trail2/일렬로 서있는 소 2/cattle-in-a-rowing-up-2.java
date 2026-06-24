import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.

        int ans = 0;
        for(int i=0;i<n;i++){
            int A1 = arr[i];
            for(int j=i+1;j<n;j++){
                int A2 = arr[j];
                if(A2<A1)
                    continue;
                for(int k=j+1;k<n;k++){
                    int A3 = arr[k];
                    if(A3<A2)
                        continue;
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }
}