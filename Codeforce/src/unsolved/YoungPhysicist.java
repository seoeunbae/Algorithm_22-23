package unsolved;

import java.util.*;

public class YoungPhysicist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] input = new int[n*3];
        for(int i = 0; i < n*3; i++) {
            input[i] = sc.nextInt();
        }

        // int n = 3;
        // int[] input = {3, -1, 7, -5, 2, -4, 2, -1, -3};

        int sum = 0;
        boolean flag = true;
        for(int i = 0; i < 3; i++) {
            for(int j = i; j < n*3; j = j + 3) {
                sum += input[j];
            }
            // System.out.println(sum);
            if(sum != 0) {
                flag = false;
                break;
            }
        }

        if(flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}