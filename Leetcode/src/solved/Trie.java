package solved;

import java.util.HashMap;

public class Trie {
    public class TrieNode{
        boolean isLast;

        HashMap<Character,TrieNode> childNodes = new HashMap<>();

        public HashMap<Character,TrieNode> getChildNodes(){
            return this.childNodes;
        }
        public boolean getIsLast(){
            return this.isLast;
        }

        public void setIsLast(boolean isLast){
            this.isLast = isLast;
        }

    }
    TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    public void insert(String word) {
        TrieNode thisNode = this.rootNode;
        for(int i=0 ; i< word.length() ; i++){
            thisNode = thisNode.childNodes.computeIfAbsent(word.charAt(i), node -> new TrieNode() );
        }
        thisNode.setIsLast(true);
    }

    public boolean search(String word) {
        TrieNode thisNode = this.rootNode;
        for(int i=0 ; i < word.length() ; i++){
            Character thisChar = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(thisChar);

            if(node == null) return false;
            thisNode = node;
        }
        return thisNode.getIsLast();
    }

    public boolean startsWith(String prefix) {//app
        TrieNode thisNode = this.rootNode;

        for(int i=0 ; i< prefix.length() ; i++){
            Character thisChar = prefix.charAt(i); //a
            TrieNode node = thisNode.getChildNodes().get(thisChar);

            if(node == null) return false;
            thisNode = node;
        }

        return true;
    }
}