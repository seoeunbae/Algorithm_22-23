package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_93 {
    static String s;
    static ArrayList<String> ips = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        restoreIpAddresses(s);

    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> current, List<String> result) {
        if (start == s.length() && current.size() == 4) {
            result.add(String.join(".", current));
            return;
        }
        if (current.size() >= 4) {
            return;
        }
        for (int i = start; i < s.length() && i <= start + 2; i++) {
            String segment = s.substring(start, i + 1);
            if (isValidSegment(segment)) {
                current.add(segment);
                backtrack(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }

    }

    private static boolean isValidSegment(String segment) {
        if (segment == null || segment.length() == 0 || segment.length() > 3) {
            return false;
        }
        if (segment.charAt(0) == '0' && segment.length() > 1) {
            return false;
        }
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }



}

