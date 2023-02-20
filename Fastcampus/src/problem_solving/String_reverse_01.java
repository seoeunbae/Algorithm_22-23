package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class String_reverse_01 {
    static String string;
    static char[] chars ;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        string = br.readLine();
        chars = new char[100000];
        chars = string.toCharArray();

        while(hasBracket(string)){
            pro(sb);
        }

        System.out.println(string);

    }

    public static void pro(StringBuffer sb){
        int start = string.indexOf("(");
        int end = string.indexOf(")");
        System.out.println(start + " "+ end);
        int first = start+1; //0+1 = 1
        int last = end-1; //5-1 = 4

        while(first < last){ //1<4
            char temp = chars[first];
            chars[first] = chars[last]; //a = d ->
            chars[last] = temp;

            first++; //2 //3
            last--; //3 //2

        }

        string = Arrays.toString(chars);
        System.out.println(string);

        for(int i=0 ; i < chars.length ; i++){
            sb.append(chars[i]);
        }

        sb.deleteCharAt(end);
        sb.deleteCharAt(start);

        string =sb.toString();

    }

    public static boolean hasBracket(String string){
        return string.contains("(") || string.contains(")");
    }

}
