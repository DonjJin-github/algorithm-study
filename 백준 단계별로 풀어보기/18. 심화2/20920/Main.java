import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> list = new HashMap<>();

        for(int i =0;i<N;i++){
            String temp = br.readLine();
            if(temp.length()>=M)
                list.put(temp,list.getOrDefault(temp, 0)+1);
        }
        String[][] word = new String[list.size()][2];

        int j=0;
        for (String string : list.keySet()) {
            word[j][0] = string;
            j++;
        }
        j=0;
        for (Integer count : list.values()) {
            word[j][1] = String.valueOf(count);
            j++;
        }

        Arrays.sort(word, (a, b) -> {
            int numCompare = Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])); 
            if (numCompare != 0) return numCompare;
        
            int lenCompare = Integer.compare(b[0].length(), a[0].length()); 
            if (lenCompare != 0) return lenCompare;
        
            return a[0].compareTo(b[0]);
        });
        
        for(int i=0;i<list.size();i++){
            bw.write(word[i][0]+"\n");
        }
        bw.flush();
    }
}
