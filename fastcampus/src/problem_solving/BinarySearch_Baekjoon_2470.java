package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch_Baekjoon_2470 {
    static int[] answer = new int[2];
//    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] list = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(list);// -99 -2 -1 4 98

        int left = 0;
        int right = n-1;
        int sum = Math.abs(list[left]+ list[right]);

        int now_left= left;
        int now_right = right;


        while(now_left < now_right){
            int check = list[now_right] + list[now_left];
            // 현재 두 포인터의 특성값
            if(Math.abs(check)< sum){
                // 현재 두 포인터의 특성값이 저장되어있는 특성값보다 작다면 정답이 될 두 용액의 인덱스를 이것으로 바꿔준다
                left = now_left;
                right= now_right;
                sum = Math.abs(check);

                if(sum == 0){
                    break;
                }
            }
            if(check > 0){
                now_right -= 1;

            } else {
                now_left+=1;
            }
        }
        System.out.println(list[left]+" "+list[right]);
    }

}
