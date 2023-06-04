package backtracking;
import java.util.*;

public class LeetCode_coinchange2 {
    public static void main(String[] args) {
        int count = change(5, new int[]{1, 2, 5});
        System.out.println(count);
    }

    public static int change(int amount, int[] coins) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), amount, coins, 0);
        return combinations.size();
    }

    public static void backtrack(List<List<Integer>> combinations, List<Integer> current, int remaining, int[] coins, int start) {
        if (remaining == 0) {
            System.out.println(current);
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < coins.length; i++) {
            if (remaining - coins[i] >= 0) {
                current.add(coins[i]);
                backtrack(combinations, current, remaining - coins[i], coins, i);
                current.remove(current.size() - 1);
            }
        }
    }
}
