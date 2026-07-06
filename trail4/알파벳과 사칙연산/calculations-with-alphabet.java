import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<String> op = new ArrayList<>();
    static ArrayList<String> list = new ArrayList<>();

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");

        for(int i=0;i<str.length;i++){
            if(i%2!=0)
                op.add(str[i]);
            else
                list.add(str[i]);
        }
        maxOp(new ArrayList<>());
        bw.write(max+"\n");
        bw.flush();
    }
    static void maxOp(ArrayList<Integer> number){
        if(number.size() == 6){
            int i=1;
            int sum = number.get(returnNum(list.get(0)));
            for(String temp : op){
                int k = number.get(returnNum(list.get(i)));

                if(temp.equals("+")){
                    sum = sum + k;
                }
                else if(temp.equals("-")){
                    sum = sum - k;
                }
                else if(temp.equals("*")){
                    sum = sum * k;
                }
                i++;
            }
            max = Math.max(max,sum);
            return;
        }
        for(int i=1;i<=4;i++){
            number.add(i);
            maxOp(number);
            number.remove(number.size()-1);
        }
    }
    static int returnNum(String str){
        if(str.equals("a"))
            return 0;
        else if(str.equals("b"))
            return 1;
        else if(str.equals("c"))
            return 2;
        else if(str.equals("d"))
            return 3;
        else if(str.equals("e"))
            return 4;
        else
            return 5;
    }
}

