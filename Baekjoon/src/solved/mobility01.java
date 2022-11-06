//package solved;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class mobility01 {
//    static String company;
//    static List<Person> list;
//
//    static StringBuilder stringBuilder = new StringBuilder();
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String S = scanner.nextLine();
//        String C = scanner.nextLine();
//        String[] names = S.split(",");
//        System.out.println(names[0]);
//        company = C.toLowerCase();
//        list = new ArrayList<>();
//        for(int i=0 ; i< names.length ; i++){ // John Doe
//
//            Person person = new Person();
//            person.initProfile(names[i] , company);
//            list.add(person);
//        }
//
//        for(int i = 0 ; i< list.size() ; i++){
//
//            String fullName = list.get(i).fullName;
//            String email = list.get(i).email;
//            stringBuilder.append(fullName).append(email);
//            if( i< list.size()-1){
//                stringBuilder.append(", ");
//            }
//        }
//        System.out.println(    stringBuilder.toString());
//
//
//
//    }
//
//    public static class Person{
//
//        String fullName;
//        String first;
//        String middle;
//        String last;
//        String nickname;
//        String domain;
//        String email;
//        public int count=1 ;
//
//        public void initProfile(String fullName, String company){ //John Doe
//            this.fullName = fullName;
//            this.nickname = generateNickname(fullName);
//            this.domain = "@".concat(company).concat(".com");
//            this.email = generateEmail(this.nickname); // "<>, "
//            initStringBuilder();
//        }
//        private String generateNickname(String fullName){
//            String[] splits = fullName.trim().toLowerCase().replace("-", "").split(" ");
//            System.out.println(splits[0]);
//            System.out.println(splits[1]);
//
//            if(splits.length == 2){
//                this.first = String.valueOf(splits[0].charAt(0));
//                this.middle = "";
//                if(splits[1].length() > 8){
//                    this.last = splits[1].substring(0,8);
//                } else this.last = splits[1];
//            } else if (splits.length == 3){
//                System.out.println(splits[0]);
//                this.first = String.valueOf(splits[0].charAt(0));
//                this.middle = String.valueOf(splits[1].charAt(0));
//                if(splits[2].length() > 8){
//                    this.last = splits[2].substring(0,8);
//                } else this.last = splits[2];
//            }
//
//            String nickname = stringBuilder.append(first).append(middle).append(last).toString();
//
//            initStringBuilder();
//
//            return nickname;
//        }
//
//        private String generateEmail(String nickname){
//            for(int i = 0 ; i < list.size() ; i++) {
//
//                if (list.get(i).nickname.equals(nickname)) {
//                    this.count++;
//                } else {
//                    String madeEmail = stringBuilder.append(" <").append(nickname).append(domain).append(">").toString();
//                    initStringBuilder();
//
//                    return madeEmail;
//                }
//            }
//
//            for(int i = 0 ; i < list.size() ; i++) {
//                if (this.count >= 2) {
//                    String madeEmail = stringBuilder.append(" <").append(nickname).append(this.count).append(domain).append(">").toString();
//                    initStringBuilder();
//
//                    return madeEmail;
//                } else {
//                    String madeEmail = stringBuilder.append(" <").append(nickname).append(domain).append(">").toString();
//                    initStringBuilder();
//
//                    return madeEmail;
//                }
//
//            }
//
//
//        }
//        private static void initStringBuilder(){
//            stringBuilder.setLength(0);
//        }
//    }
//}
