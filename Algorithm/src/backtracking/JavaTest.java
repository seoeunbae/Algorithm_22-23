package backtracking;

public class JavaTest {
    public static void main(String[] args) {
        int level = 10;
        //1. +1해보기
        printLevel(level+1);
        System.out.println("level+1 : " + level);

        level = 10;
        //2. 증감연산자
        printLevel(++level);
        System.out.println("level++ : " + level);
        level = 10;
        //3. 재귀
        printLevel(level);
        System.out.println("wornl" + level);

    }

    public static void printLevel(int x){
        if (x == 15) return;
        System.out.println("printLevel method : "+ x);
        printLevel(x+1);
    }
}
