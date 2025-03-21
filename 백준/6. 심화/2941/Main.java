import java.io.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        int index = 0;
        int count = 0;

        while (index<str.length) {
            switch (str[index]) {
                case "c":
                    if(index+1<str.length)
                        if(str[index+1].equals("=")||str[index+1].equals("-"))
                            index++;
                    count++;
                    break;
                case "d":
                    if(index+1<str.length)
                        if(str[index+1].equals("-"))
                            index++;
                        else if(index+2<str.length&&str[index+1].equals("z")&&str[index+2].equals("="))
                            index+=2;
                    count++;
                    break;
                case "l": case "n":
                    if(index+1<str.length)
                        if(str[index+1].equals("j"))
                            index++;
                    count++;
                    break;
                case "s": case "z":
                    if(index+1<str.length)
                        if(str[index+1].equals("="))
                            index++;
                    count++;
                    break;
                default:
                    count++;
                    break;
            }
            index++;
        }

        bw.write(count+"\n");
        bw.flush();
    }
}
