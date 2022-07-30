package solved;

import java.util.Arrays;
import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(Func(string));
    }

    public static int Func(String string){
        char[] chars = string.toCharArray();
        int[] intArray = new int[chars.length];
        int result =0;
        for(int i=0;i<chars.length;i++){
            switch(chars[i]){
                case 'I': {
                    result+=1;
                    intArray[i]=1;
                    break;
                }
                case 'V':{
                    result+=5;
                    intArray[i]=5;
                    break;
                }
                case 'X': {
                    result+=10;
                    intArray[i]=10;
                    break;
                }
                case 'L':{
                    result+=50;
                    intArray[i]=50;
                    break;
                }
                case 'C': {
                    result+=100;
                    intArray[i]=100;
                    break;
                }
                case 'D':{
                    result+=500;
                    intArray[i]=500;
                    break;
                }
                case 'M': {
                    result+=1000;
                    intArray[i]=1000;
                    break;
                }
            }
        }
        for(int i=0 ; i< intArray.length-1; i++){
            if(intArray[i] < intArray[i+1]) result+= intArray[i]*-2;
            else continue;
        }
        return result;
    }
}
