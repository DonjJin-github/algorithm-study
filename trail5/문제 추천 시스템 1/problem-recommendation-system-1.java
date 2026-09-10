import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int pnum;
        int level;

        Node(int pnum, int level){
            this.pnum = pnum;
            this.level = level;
        }

        @Override
        public int compareTo(Node newNode){
            if(level == newNode.level){
                return Integer.compare(pnum, newNode.pnum);
            }
            return Integer.compare(level, newNode.level);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Node> set = new TreeSet<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int pnum = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            set.add(new Node(pnum, level));
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int pnum = 0;
            int level = 0;

            switch(op){
                case "ad":
                    pnum = Integer.parseInt(st.nextToken());
                    level = Integer.parseInt(st.nextToken());
                    set.add(new Node(pnum, level));
                    break;
                
                case "sv":
                    pnum = Integer.parseInt(st.nextToken());
                    level = Integer.parseInt(st.nextToken());
                    Node remove = new Node(pnum, level);
                    set.remove(remove);
                    break;

                case "rc":
                    int x = Integer.parseInt(st.nextToken());
                    if(x==1){
                        bw.write(set.last().pnum+"\n");
                    }else{
                        bw.write(set.first().pnum+"\n");
                    }
                    break;

                default:
                    break;
            }
        }
        bw.flush();
    }
}