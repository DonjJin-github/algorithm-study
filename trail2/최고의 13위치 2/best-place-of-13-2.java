import java.util.*;

public class Main {
    static class Node{
        int a;
        int x;
        int y;

        Node(int a, int x, int y){
            this.a = a;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
       
        // Please write your code here.
        ArrayList<Node> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<=n-3;j++){
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                list.add(new Node(sum, i, j));
            }
        }

        int ans = 0;

        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){

                Node a = list.get(i);
                Node b = list.get(j);

                if(a.x == b.x && Math.abs(a.y - b.y) < 3)
                    continue;

                ans = Math.max(ans, a.a + b.a);
            }
        }

        System.out.println(ans);


    }
}