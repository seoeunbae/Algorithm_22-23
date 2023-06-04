package kakao2023blind;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;
import java.util.*;

public class SofteerPro1 {
    static HashMap<String, Integer> countMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Element> FQ = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if ( countMap.get(o2).equals(countMap.get(o1))) {
                    return o1.index - o2.index;
                } else {
                    return countMap.get(o2) - countMap.get(o1);
                }
            }
        });



        int dequeueCount = 0;
        Integer N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            String cmd = s[0];
            if (cmd.equals("enqueue")) {
                String model = s[1];
                int count = countMap.getOrDefault(model, 0);
                countMap.put(model, count + 1);

                Element element = new Element(model, countMap.get(model), i);
                FQ.add(element);
            } else {
                Element element = FQ.poll();
                if (element == null) {
                    System.out.print("*");
                } else {
                    countMap.put(element.model, countMap.get(element.model) - 1);

                    System.out.print(element.model + " ");
                }
            }
        }

//        FQ.sort(new Comparator<Element>() {
//            @Override
//            public int compare(Element o1, Element o2) {
//                if (o2.count == o1.count){
//                    return FQ.indexOf(o1)- FQ.indexOf(o2);
//                } else {
//                    return o2.count - o1.count;
//                }
//            }
//        });


//        for(int i=0 ; i < dequeueCount ; i++){
//
//        }


    }


    public static class Element {
        String model;
        Integer count;

        int index;

        Element(String model, Integer count, int index){
            this.model =model;
            this.count = count;
            this.index = index;
        }


    }

}
