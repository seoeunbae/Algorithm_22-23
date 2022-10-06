package solved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class KakaoCodeTest01 {

    static int monthOfDeadline;
    static int yearOfDeadline;
    static int dateOfDeadline;
    static List<Integer> answerList = new ArrayList<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        int yearOfToday = Integer.parseInt(today.split("[.]")[0]);
        int monthOfToday = Integer.parseInt(today.split("[.]")[1]);
        int dateOfToday= Integer.parseInt(today.split("[.]")[2]);

        HashMap<String, Integer> termsMap = new HashMap<>();
        for(int i=0 ; i<terms.length ; i++){
            String kind = terms[i].split(" ")[0];
            int term = Integer.parseInt(terms[i].split(" ")[1]);
            termsMap.put(kind, term);
        }

        for(int i=0 ; i< privacies.length ; i++){
            String date = privacies[i].split(" ")[0];
            String kind = privacies[i].split(" ")[1];

            Integer yearOfStart = Integer.valueOf(date.split("[.]")[0]);
            Integer monthOfStart = Integer.valueOf(date.split("[.]")[1]);
            Integer dateOfStart = Integer.valueOf(date.split("[.]")[2]);
            int temp = monthOfStart + termsMap.get(kind);  //달

            if (temp > 12) {
                yearOfDeadline= yearOfStart + termsMap.get(kind) / 12;
                monthOfDeadline = monthOfStart + termsMap.get(kind) % 12;
                if( monthOfDeadline > 12){
                    yearOfDeadline += 1;
                    monthOfDeadline -= 12;
                }
            } else {
                yearOfDeadline = yearOfStart;
                monthOfDeadline = temp;
            }
            dateOfDeadline = dateOfStart;

            if( yearOfToday > yearOfDeadline || yearOfToday == yearOfDeadline && monthOfToday > monthOfDeadline || yearOfToday == yearOfDeadline && monthOfToday == monthOfDeadline && dateOfToday >= dateOfDeadline){
                answerList.add(i+1);
            }

        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}