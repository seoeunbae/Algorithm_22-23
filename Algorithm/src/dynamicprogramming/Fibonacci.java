package dynamicprogramming;

public class Fibonacci {
    public int fibonacci(int data){
        if(data <= 1){
            return data;
        } else if( data ==2){
            return 2;
        } else {
            return fibonacci(data-1)+fibonacci(data-2);
        }
    }
}
