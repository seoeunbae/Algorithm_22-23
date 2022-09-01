package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_2841 {

    static Integer N;
    static Integer P;
    static Integer stringNumber;
    static Integer pNumber;

    static Stack<Integer>[] stackArray;
    static Integer answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        N = Integer.valueOf(firstLine[0]);
        P = Integer.valueOf(firstLine[1]);
        stackArray = new Stack[7];
        for( int i=0 ; i<=6 ; i++){
            stackArray[i] = new Stack<>();

        }

        for(int i=0 ; i < N ; i++){
            String[] numbers = br.readLine().split(" ");
            stringNumber = Integer.valueOf(numbers[0]);
            pNumber = Integer.valueOf(numbers[1]);
            Func(stringNumber, pNumber);
        }
        System.out.println(answer);

    }

    public static void Func(Integer stringNumber, Integer pNumber){

        while(!stackArray[stringNumber].isEmpty() && stackArray[stringNumber].peek() > pNumber){
            stackArray[stringNumber].pop();
            answer++;
        }

        if(stackArray[stringNumber].isEmpty() || (!stackArray[stringNumber].isEmpty() && stackArray[stringNumber].peek() < pNumber)){
            stackArray[stringNumber].push(pNumber);
            answer++;
        }

    }
}
