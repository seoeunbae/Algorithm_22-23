package recursive;

public class Factorial {
    public static int factorialFunc(int n){
        if(n>1){
            return n * factorialFunc(n-1);
        } else {
            return 1;
        }
    }

    public static int factorial2Func(int n){
        if(n<=1){
            return 1;
        } else{
            return n * factorial2Func(n-1);
        }
    }

    public static void main(String[] args) {
        factorialFunc(5);
        factorial2Func(5);
    }
}

//n-1번의 factorial()함수를 호출한것이다. 즉, n-1번 반복문 호출==O(n-1)==O(n)
// 시간복잡도: O(n)
//함수는 내부적으로 스택처럼 관리된다.
//실행되는 순서대로 쌓이다가 return 되면 위에서부터 해제된다.
