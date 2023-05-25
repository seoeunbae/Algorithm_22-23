package kakao2023blind;

import java.time.LocalDate;
import java.util.*;
import java.time.*;

class PrivacyTermValid {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> term = new HashMap<>();
        // String[] todays = today.split("\\.");
        int todayDay = getDate(today);
        // int year = Integer.parseInt(todays[0]);
        // Integer month = Integer.valueOf(todays[1]);
        // int date = Integer.valueOf(todays[2]);
        // LocalDate todayDay = LocalDate.of(year, month, date);

        for(int i=0 ; i < terms.length ; i++){
            String[] eachTerm = terms[i].split(" ");
            term.put(eachTerm[0], Integer.valueOf(eachTerm[1]));
        }

        for(int i=0 ; i<privacies.length ; i++){
            String[] privacy = privacies[i].split(" ");
            String ofTerm = privacy[1];
            // String[] startDay = privacy[0].split("\\.");
//             int startYear = Integer.parseInt(startDay[0]);
//             Integer startMonth = Integer.valueOf(startDay[1]);
//             int startDate = Integer.valueOf(startDay[2]);

            Integer temp = term.get(ofTerm) * 28 + getDate(privacy[0]);

            // Integer validMonth = temp % 13;
            // if(validMonth == 0){
            //     validMonth = 1;
            // }
            // int validYear = startYear + (temp / 12);



            if(todayDay - temp >= 0){
                result.add(i+1);
            }
        }



        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
