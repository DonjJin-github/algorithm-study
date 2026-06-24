import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Please write your code here.
        String[] A = str.split("");

        int ans = 0;
        for(int i=0;i<A.length;i++){
            if(A[i].equals(")"))
                continue;
            for(int j=i+1;j<A.length;j++){
                if(A[j].equals(")"))
                    ans++;
            }
        }

        System.out.print(ans);
    }
}