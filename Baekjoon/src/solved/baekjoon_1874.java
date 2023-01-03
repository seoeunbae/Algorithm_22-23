package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class baekjoon_1874 {
    static Stack<Integer> stack = new Stack<>();
    static int num;
    static int index=1;
    static boolean result = true;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        for(int i=0 ; i< N ; i++){
            num = Integer.parseInt(br.readLine());
            if(num >= index){
                while(num >= index){
                    stack.add(index);
                    index++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                Integer remove = stack.pop();
                if(remove > num){
//                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }

        if(result) System.out.println(sb.toString());
        else System.out.println("NO");
    }


}
