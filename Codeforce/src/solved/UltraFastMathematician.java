package solved;

import java.io.*;

public class UltraFastMathematician {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split("");
        String[] secondLine = br.readLine().split("");
        Func(firstLine, secondLine);
    }

    public static void Func(String[] firstLine, String[] secondLine) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<firstLine.length;i++){
            if(firstLine[i].equals(secondLine[i])){
                bw.append('0');
            } else {
                bw.append('1');
            }
        }

        bw.flush();
    }
}
