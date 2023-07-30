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

    public int dynamicFibonacci(int data){//시간복잡도 대신 공간복잡도를 희생시킨 측면이 있다.
        Integer[] cache = new Integer[data+1];
        cache[0] = 0;
        cache[1] = 1;
        for(int index=2;index<data+1;index++){
            cache[index] = cache[index-1]+cache[index-2];
        }
        return cache[data];
    }

    //**분할정복 알고리즘은 나중에 다루는 병합정렬과 퀵정렬(O(nlogn))을 통해 알아보자**
}
