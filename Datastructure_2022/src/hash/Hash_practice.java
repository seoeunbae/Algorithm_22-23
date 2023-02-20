package hash;

public class Hash_practice {

    public class Myhash {
        public Slot[] hashTable;

        Myhash(Integer size){
            hashTable = new Slot[size];
        }

        public int hashFunc(String key) {
            return (int) (key.charAt(0)) % this.hashTable.length;
        }

        public boolean saveData(String key, String value){
            Integer address = this.hashFunc(key);

            if(hashTable[address] != null){
//                hashTable[address].value = value;
                if(hashTable[address].key.equals(key)) {
                    Slot findSlot = hashTable[address];
                    Slot prevSlot = hashTable[address];
                    while(findSlot != null){
                        if(findSlot.key ==key){
                            findSlot.value = value;
                            return true;
                        } else{
                            prevSlot = findSlot;
                            findSlot = findSlot.next;
                        }
                    }
                    prevSlot.next = new Slot(key,value);
                }
            } else{
                hashTable[address] = new Slot(value, key);
            }

            return true;
        }

        public String getData(String key){
            Integer address = hashFunc(key);

            if(hashTable[address] != null){
//                return hashTable[address].value;
                Slot findSlot = hashTable[address];

                while(findSlot != null){
                    if( findSlot.key != key) {
                        findSlot = findSlot.next;
                    } else return findSlot.value;
                }
                return null;
            }else {
                return null;
            }
        }
    }
    public class Slot{
        String key;
        String value;
        Slot next;
        Slot(String value, String key){
            value = value;
            key = key;
        }
    }


}
