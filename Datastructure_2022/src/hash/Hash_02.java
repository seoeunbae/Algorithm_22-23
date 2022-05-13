package hash;

public class Hash_02 {
    public static class MyHash {
        public Slot[] hashTable; // 객체배열

        public MyHash(Integer size) {
            this.hashTable = new Slot[size];
        }

        public class Slot {
            String value;
            String key;
            Slot next;
            Slot(String key, String value) {
                this.key = key;
                this.value = value;
                this.next = null;
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
                Slot findSlot = this.hashTable[address];
                Slot prevSlot = this.hashTable[address];
                while(findSlot != null){
                    if(findSlot.key == key){
                        findSlot.value = value;
                        return true;
                    } else{
                        prevSlot = findSlot;
                        findSlot = findSlot.next;
                    }
                }
                prevSlot.next = new Slot(key, value);
            } else {
                this.hashTable[address] = new Slot(key,value);
            }
            return true;
        }

        public String getData(String key) {
            Integer address = this.simpleHashFunction01(key);
            if (this.hashTable[address] != null) {
                Slot findSlot = this.hashTable[address];
                while(findSlot != null){
                    if(findSlot.key == key){
                        return findSlot.value;
                    } else{
                        findSlot = findSlot.next;
                    }
                }
                return null;
            } else {
                return null;
            }

        }
    }


}
