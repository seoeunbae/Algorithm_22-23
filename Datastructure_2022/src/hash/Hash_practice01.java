package hash;

public class Hash_practice01 {



    public static class Slot{
        String value;
        String key;
        Slot next;

        Slot(String key, String value){
            key = key;
            value= value;
        }
    }


    public class MyHash{

        public Slot[] hashTable;

        MyHash(Integer size){
            hashTable = new Slot[size];
        }

        public boolean saveData(String key, String value){
            Integer address = hashFunc(key);

            if(hashTable[address] != null){
                if(hashTable[address].key.equals(key)) {
                    Slot findSlot = hashTable[address];
                    Slot prevSlot = hashTable[address];
                    while (findSlot != null) {
                        if (findSlot.key != key) {
                            prevSlot = findSlot;
                            findSlot = findSlot.next;
                        } else {
                            findSlot.value = value;
                            return true;
                        }
                    }
                    prevSlot.next = new Slot(key, value);
                }

            } else hashTable[address] = new Slot(key, value);
            return true;
        }

//        public void getData(String key){
//            if(){
//
//            }
//        }

        public int hashFunc(String key){
            return (int) (key.charAt(0)) % hashTable.length;
        }
    }

}
