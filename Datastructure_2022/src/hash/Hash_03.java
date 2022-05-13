package hash;
//Linear Probing기법,폐쇄해슁기법을 구현한 코드.
public class Hash_03 {
    public static class MyHash{
        public Slot[] hashTable; // 객체배열

        public MyHash(Integer size) {
            this.hashTable = new Slot[size];
        }

        public class Slot {
            String value;
            String key;
//            Slot next;
            Slot(String key, String value) {
                this.key = key;
                this.value = value;
//                this.next = null;
            }
        }

        public int simpleHashFunction01(String key) {
            char first = key.charAt(0);
            int firstInt = (int) first;
            return firstInt % this.hashTable.length;
        }

        public boolean saveData(String key, String value) {
            Integer address = this.simpleHashFunction01(key);
            if (this.hashTable[address] != null) {
                if(this.hashTable[address].key == key){
                    this.hashTable[address].value = value;
                    return true;
                } else {
                    Integer currAddress = address + 1;
                    while(this.hashTable[currAddress].key != null){
                        if(this.hashTable[currAddress].key == key){
                            this.hashTable[currAddress].value = value;
                            return true;
                        } else {
                            currAddress++;
                            if(currAddress>=this.hashTable.length){
                                return false;
                            }
                        }
                    }
                    this.hashTable[currAddress]= new Slot(key,value);
                    return true;
                }
            } else {
                this.hashTable[address] = new Slot(key,value);
            }
            return true;
        }

        public String getData(String key) {
            Integer address = this.simpleHashFunction01(key);
            if (this.hashTable[address] != null) {
                if(this.hashTable[address].key == key){
                    return this.hashTable[address].value;
                } else{
                    Integer currAddress = address +1;
                    while(this.hashTable[currAddress] != null){
                        if(this.hashTable[currAddress].key == key){
                            return this.hashTable[currAddress].value;
                        }else{
                            currAddress++;
                            if(currAddress>= this.hashTable.length){
                                return null;
                            }
                        }
                    }
                    return null;
                }
            } else {
                return null;
            }

        }
    }
}
