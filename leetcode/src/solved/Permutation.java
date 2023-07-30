package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
    static int length;
    static int[] nums;
    static List<Integer> numList;

    public List<List<Integer>> main(int[] nums) {
        length = nums.length;
        nums = nums;
        numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> output = new ArrayList<>();
        for (Integer num : numList) {
            List<Integer> letters = new ArrayList<>(List.of(num));
            backtracking(1, letters, output);
        }

        return output;
    }

    public static List<List<Integer>> permute(int level, List<Integer> letters, List<List<Integer>> output) {
        length = nums.length;
        Arrays.stream(nums).boxed().collect(Collectors.toList());
        nums = nums;
        backtracking(0, letters, output);
        System.out.println(output);
        return output;
    }

    public static void backtracking(int level, List<Integer> letters, List<List<Integer>> output) {
        //System.out.println(letters + " "+ level );
        if (level == length) {

            output.add(new ArrayList<>(letters));
            return;
        }

        for (int each : numList) {

            if (!letters.contains(each)) {
                letters.add(each);

                backtracking(level + 1, letters, output);
                letters.remove((Integer) each);
            }
        }

    }
}