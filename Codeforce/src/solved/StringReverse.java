package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        char[] chars = string.toCharArray();

        int length = chars.length;
        func(chars);
//        for(int i=0 ; i < length / 2 ; i++){
//            char temp = chars[i];
//
//            chars[i] = chars[length-1-i];
//            chars[length-1-i] = temp;
//
//        }
//
//
//        System.out.println(chars);
    }

    public static void func(char[] chars){
        int length = chars.length;
        int fi = 0;
        int li = length-1; //5

        while(fi < li){
            if(chars[fi]!='(') fi++; //fi=2
            if(chars[li]!=')') li--; //li=7
            //int len = li-fi;// = 4 //
            for(int i = fi ; i <= li ; i++){
                if(chars[i] =='(' || chars[i] == ')') chars[i] = '0';
                //3
                char temp = chars[i]; //e,3

                chars[i] = chars[length-1-i];
                chars[length-1-i] = temp;
            }
        }
        for(char each: chars){
            if(each=='0') continue;
            System.out.print(each);
        }
    }



}
