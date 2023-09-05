package solved;

import java.util.ArrayList;
import java.util.Stack;

public class EmojiSale {

    static ArrayList<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        solution(users, emoticons);
        char[] chars = new char[10];
        chars.toString()
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int maxPercent = 0;
        int minPercent = 99999999;
        for(int i = 0 ; i < users.length ; i++) {
            if (maxPercent < users[i][0]) {
                maxPercent = users[i][0];
            }
            if (minPercent > users[i][0]) {
                minPercent = users[i][0];
            }
            User user = new User(users[i][0], users[i][1]);
            userList.add(user);
        }
        int serviceUser = 0;
        int tsu = 0;
        int tm = 0;
        int ttm = 0;
        while(maxPercent > minPercent){
            int money=0;

            ttm = 0;
            for(User user : userList){
                money = 0;
                serviceUser=0;
                tm=0;
                ttm=0;
                int emojiPrice= 0;
                for(int emoji : emoticons){
                    emojiPrice = emoji*(1-maxPercent/100);
                    if (user.percent <= maxPercent) money += emojiPrice;
                }
                if (money > user.price){
                    serviceUser++;
                    money -= emojiPrice;
                }
            }

            if (serviceUser >= tsu) { //
                tsu = serviceUser;
                if( ttm <= money ){
                    ttm = money;
                    System.out.println(money);
                    System.out.println(maxPercent);
                }

            }
            maxPercent--;
        }
        System.out.println(tsu+ " " + ttm);
        return new int[]{tsu, ttm};
    }

    public static class User{
        int percent;
        int price;
        User(int percent, int price){
            this.percent = percent;
            this.price = price;
        }
    }
}
