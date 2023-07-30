package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hulk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer integer = Integer.valueOf(br.readLine());
        Func(integer);
    }

    public static void Func(int integer){
        for(int i=0 ; i< integer ; i++){
            if(i%2==0){
                System.out.printf("I hate ");
            } else{
                System.out.printf("I love ");
            }
            if( i != integer-1){
                System.out.printf("that ");
            } else {
                System.out.printf("it ");
            }
        }
    }
}
