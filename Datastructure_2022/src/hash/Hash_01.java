package hash;
//Chaining기법,개방해슁을 구현한 코드.
public class Hash_01 {
    public static class MyHash{
        public Slot[] hashTable; // 객체배열
        public MyHash(Integer size){
            this.hashTable = new Slot[size];
        }

        public class Slot{
            String value;

            Slot(String value){
                this.value = value;
            }
        }

        public int simpleHashFunction01(String key){
            char first = key.charAt(0);
            int firstInt = (int)first;
            return firstInt % this.hashTable.length;
        }

        public boolean saveData(String key, String value){
            Integer address = this.simpleHashFunction01(key);
            if( this.hashTable[address] != null){
                this.hashTable[address].value = value;
            } else{
                this.hashTable[address]= new Slot(value);
            }
            return true;
        }

        public String getData(String key){
            Integer address = this.simpleHashFunction01(key);
            if( this.hashTable[address] != null){
                return this.hashTable[address].value;
            }else{
                return null;
            }

        }

        public static void main(String[] args) {
            MyHash mainObject = new MyHash(20);
            System.out.println(mainObject.saveData("Seoeun","01099999999"));
            System.out.println(mainObject.saveData("Bae","010999992333"));
            System.out.println(mainObject.getData("Bae"));
        }
    }
}
