package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Baekjoon_10972 {
    static int N ;

    static ArrayList<ArrayList<Integer>> letters = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> collect = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        List<Integer> result = nextPermutation(collect);

        for(int num : result){
            System.out.print(num+" ");
        }
    }

    private static List<Integer> nextPermutation(List<Integer> nums) {
        int n = nums.size();
        int i = n - 2;
        while (i >= 0 && nums.get(i) >= nums.get(i+1)) {
            i -= 1;
        }

        if (i == -1) {
            return Collections.singletonList(-1);
        }

        int j = n - 1;
        while (nums.get(j) <= nums.get(i)) {
            j -= 1;
        }

        Collections.swap(nums, i, j);
        Collections.reverse(nums.subList(i+1, n));
        return nums;
    }
}
