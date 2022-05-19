package recursive;
//정수n을 1,2,3의 합으로 나타낼 수 있는 방법의 수
public class N123 {
    public class Factorial{
        public int factorialFunc(int data){
            if(data == 1){
                return 1;
            } else if(data==2) {
                return 2;
            } else if(data ==3){
                return 4;
            }
            return factorialFunc(data-1)+ factorialFunc(data -2) + this.factorialFunc(data-3);

        }
    }
}
