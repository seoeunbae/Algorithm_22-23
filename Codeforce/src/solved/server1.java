package solved;

import java.util.*;
import java.util.stream.Stream;

public class server1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextLine()));
    }

    public static int solution(String s) {

        char[] chars = s.toCharArray();

        int[] intArray = new int[chars.length];

        List<Integer> intList = new ArrayList<>();
        List<Integer> answerCandidate = new ArrayList<>();
        if(s.length() < 3){
            return -1;
        } else {


        for(int i=0;i<chars.length;i++){
            intList.add(Integer.parseInt(String.valueOf(chars[i])));
            System.out.println(intList.get(i));
        }

//        Integer max = Collections.max(intList); //최댓값
//        Integer index = intList.indexOf(max);  //최댓값의 인덱스
        while(true) {
            Integer max = Collections.max(intList, Comparator.naturalOrder()); //최댓값
            Integer index = intList.indexOf(max);
            if (intList.size() >= index+3) {
                System.out.println(intList.size());
                char[] temp = String.valueOf(intList).substring(index, index + 3).toCharArray();
                if(temp[0] == temp[1] && temp[1] == temp[2]) {
                    System.out.println(Integer.parseInt(String.valueOf(temp)));
                    answerCandidate.add(Integer.parseInt(String.valueOf(temp)));
                }
            } else {
                intList.remove(index);
            }
            break;
        }
        int answer = 0;
        if(!answerCandidate.isEmpty()) {
            answer = Collections.max(answerCandidate);
        }
        return answer;
        }
    }
}
