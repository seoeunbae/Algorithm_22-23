package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Greedy02 {
    //정렬기준정의하는법
    public static class knapsack{
        public void Func(double capacity){
            Integer[][] objectList = {{10, 10}, {15,12}, {20,10},{25,8},{30,5}};
            double totalValue = 0.0;
            double fraction = 0.0;

            Arrays.sort(objectList, new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    return (o2[1]/o2[0]) - (o1[1]/o2[0]);
                }
            });


            for(int index = 0 ; index < objectList.length ; index++) {
                if((capacity - (double)objectList[index][0]>0)) {
                    capacity -= (double) objectList[index][0];
                    totalValue += (double) objectList[index][1];

                }else{
                    fraction = capacity/(double) objectList[index][0];
                    totalValue +=(double) objectList[index][1]*fraction;
                    break;
                }

            }
            System.out.println();

        }
    }
    //COMPARABLE 과 comparator 인터페이스
    // - Comparable 인텊이스는 COmpareTo메소드를 오버라이드해서 구현/일반적으로 정렬할객체에 implements로 인터페이스를 추가해서 구현
    // - Comparator 인터페이스는 compare메소드를 오버라이드해서 구현/일반적을 별도 클래스를 정의해서 구현, 동일객체에 다양한 정렬 기준을 가진 클래스를 작성할수 있다.

    public static class Edge implements Comparable<Edge>{
        public Integer distance;
        public String vertex;

        public Edge(Integer distance, String vertex){
            this.distance = distance;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge e) {
            return this.distance-e.distance;
        }
    }

    public static void main(String[] args) {
        Edge e1 = new Edge(10, "A");
        Edge e2 = new Edge(12, "A");
        Edge e3 = new Edge(14, "A");
        Edge[] edges = new Edge[]{e1, e2, e3};
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.distance-o1.distance;
            }
        });
        for(int index = 0 ; index < edges.length ; index++){
            System.out.println(edges[index].distance);
        }
    }
}
//정렬기준이 중복될 경우 COmparator가 우선순위를 가진다. (Comparable보다)

