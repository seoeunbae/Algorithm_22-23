package hash;

 class HashTable {

    Slot[] table;

    HashTable(Integer size) {
        table = new Slot[size];
    }

    public class Slot{
        String value;

        Slot(String value){
            this.value = value;
        }
    }

    public  int basicHashing(String key){
        int length = table.length;
        int firstInt = key.charAt(0)-'0';
        return firstInt % length;
    }

    public Slot saveData(String key, String value){
        Slot slot = new Slot(value);
        int address = basicHashing(key);
        this.table[address] = slot;
        return this.table[address];
    }

    public Slot getData(String key) {
        int address = basicHashing(key);
        return this.table[address];
    }

     public static void main(String[] args) {
         HashTable hashTable = new HashTable(20);
         hashTable.saveData("seoeun" , "01099999999");
         hashTable.saveData("triple", "0103333333");
         System.out.println(hashTable.getData("triple").value);
         System.out.println(hashTable.getData("seoeun").value);

     }

}

