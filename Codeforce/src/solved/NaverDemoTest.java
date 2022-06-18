package solved;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class NaverDemoTest {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int max = A[0];
        for(int i=0;i<A.length;i++){
            if(max < A[i]){
                max = A[i];
            }
        }
        if(max<0) return 1;
        else if (max > 0 && !emptyExist(A, max)){
            return max+1;
        }else
//            if( max> 0 && emptyExist(A, max))
            {
            return findEmpty(A, max);
        }
    }

    public static boolean emptyExist(int[] A, int max){
        long count = Arrays.stream(A).count();
        return (int)count != max;
    }

    public static int findEmpty(int[] A, int max){
        int[] integer = new int[max];
        for(int i=0;i<A.length;i++){
            integer[A[i]]=1;
        }
        System.out.println(integer);
        int index = integer.toString().indexOf(0);
        return index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] integer = new int[s.length];
        for(int i =0 ; i< s.length;i++){
            int m = Integer.parseInt(s[i]);
            integer[i] = m;
        }
        System.out.println(integer.toString());
        System.out.println(solution(integer));
    }
}
