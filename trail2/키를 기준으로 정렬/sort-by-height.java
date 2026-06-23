import java.util.*;
import java.io.*;

public class Main {
    static class Student implements Comparable<Student>{
        String name;
        int height;
        int weight;

        Student(String name, int height, int weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Student newStudent){
            return Integer.compare(height, newStudent.height);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Student[] arr = new Student[n];

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            arr[i] = new Student(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
        }

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            bw.write(arr[i].name+" "+ arr[i].height+" "+arr[i].weight+"\n");
        }        
        bw.flush();

    }
}