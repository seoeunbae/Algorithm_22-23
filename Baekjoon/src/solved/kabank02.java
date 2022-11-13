package solved;

public class kabank02 {

    public static void main(String[] args) {
        int month  = 4 ;
        int resultMoney = money;
        int monthlyMoney;

        for(int i=0 ; i<month ; i++){
            resultMoney -= Func();

        }
    }


    public int Func(int money, int minratio, int maxratio, int ranksize, int threshold, int months){
        int ownMoney = (money/100)*100;

        int minuMoney = 0;
        if ( threshold < ownMoney && (threshold+ranksize-1) > ownMoney ) {
            minuMoney += ownMoney * (minratio)/100;
        } else {
            int m =  (ownMoney - threshold) / ranksize;
            if( m < maxratio){
                minuMoney = ownMoney * ((minratio+m)/100);
            } else minuMoney = ownMoney * (maxratio/100);
        }

        return minuMoney;
    }
}


class Solution {
    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        int answer = 0;
        int rate= 0;
        for(int i=0 ; i<months ; i++){
            rate += Func(money, minratio, maxratio, ranksize, threshold, months);

        }
        return money - rate;

    }

    public int Func(int money, int minratio, int maxratio, int ranksize, int threshold, int months){
        int ownMoney = (money/100)*100;

        int rate = 0;
        if ( threshold < ownMoney && (threshold+ranksize-1) > ownMoney ) {
            rate += ownMoney * (minratio)/100;
        } else {
            int m =  (ownMoney - threshold) / ranksize;
            if( m < maxratio){
                rate = ownMoney * ((minratio+m)/100);
            } else rate = ownMoney * (maxratio/100);
        }

        return rate;
    }
}