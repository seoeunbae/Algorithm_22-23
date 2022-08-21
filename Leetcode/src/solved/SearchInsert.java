package solved;

import java.util.Arrays;
import java.util.Scanner;

public class SearchInsert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int target = Integer.parseInt(scanner.nextLine());
        int[] integers = new int[chars.length];
        for(int i=0;i<chars.length;i++){
            System.out.println("chars[i]: " +chars[i]);

            Integer integer = Integer.parseInt(Character.toString(chars[i]));

            integers[i] = integer;
            System.out.println("integers : "+ integers[i]);
        }
        System.out.println(searchInsert(integers, target));
    }

    public static int searchInsert(int[] nums , int target){
        int answer = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==target){
                    return i;
                } else if(nums[i] < target){
                    if (i == nums.length-1) return i+1;
                    else continue;
                } else return i;


            }
            return answer;
    }
}
