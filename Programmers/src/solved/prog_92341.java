package solved;


import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.*;

public class prog_92341 {
    static HashMap<Integer, Car> map = new HashMap<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicPrice = fees[1];
        int perTime = fees[2];
        int perPrice = fees[3];
        ArrayList<int[]> in = new ArrayList<>();

        for(int i = 0 ; i < records.length ; i++){
            String[] splits = records[i].split(" ");

            String[] sp = splits[0].split(":");
            int hour = 60 * Integer.parseInt(sp[0]);
            int min = Integer.parseInt(sp[1]);
            int time = hour + min;

            int num = Integer.parseInt(splits[1]);
            String inout = splits[2];
            if( inout.equals("IN") ){
                in.add(new int[]{time, num});//시작시간
                map.putIfAbsent(num, new Car(num, 0, 0));
            } else {
                for(int j=0 ; j < in.size() ; j++){
                    if(in.get(j)[1] == num){
                        int start = in.get(j)[0];
                        int during = time - start;//주차 동안 시간
                        in.remove(j);
                        map.put(num, new Car(num, map.get(num).time + during, 0));
                        break;
                    }
                }
            }

        }

        if(in.size() >= 1){
            for(int[] each : in){
                int end = 60 * 23 + 59;
                int during = end - each[0];
                map.get(each[1]).time += during;
            }
        }

        Set<Integer> integers = map.keySet();
        for(Integer each : integers){
            pq.offer(each);
        }
        int[] answer = new int[integers.size()];
        int len = pq.size();
        for(int i=0 ; i < len ; i++){
            Integer num = pq.poll();

            int p = (int) calcul(map.get(num).time,fees);

            answer[i] = p;
        }
        return answer;
    }

    public double calcul(int time, int[] fees){
        if(time <= fees[0]) return fees[1];
        time -= fees[0];
        int p = fees[1];

        p += (time / fees[2]) * fees[3];
        int rest = time % fees[2];
        if(rest != 0){
            p += fees[3];
        }

        return p;
    }

    public static class Car implements Comparable<Car>{
        int num;
        int time;
        int price;

        Car(int num , int time, double price){
            this.num = num;
            this.time = time;
            this.price = ((int) price);
        }

        @Override
        public int compareTo(Car car){
            return this.num - car.num;
        }

    }
}