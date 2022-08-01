package solved;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(Func(s));
    }


    public static boolean Func(String s) {
        char[] chars = s.toCharArray();
        if( chars.length % 2 != 0) return false;

        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[',']');
        map.put('(',')');

        List<Character> stack = new ArrayList<>();


        for(int i=0;i<s.length();i++){
            if(stack.isEmpty() && (chars[i]==')'||chars[i]=='}'||chars[i]==']' )) return false;
            if(chars[i] == '{' || chars[i] == '(' || chars[i] == '['){
                stack.add(chars[i]);
                continue;
            }
            if(chars[i] == map.get(stack.get(stack.size()-1))){
                stack.remove(stack.size()-1);
                continue;
            }
            return false;
        }
        return stack.size()==0;
    }
}
