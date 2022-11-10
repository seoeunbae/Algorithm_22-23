package solved;

import java.util.HashMap;

class WordDictionary {
    private class TrieNode{
        private boolean isLast;
        private HashMap<Character, TrieNode> childNodes = new HashMap<>();

        public boolean getIsLast(){
            return isLast;
        }

        public HashMap<Character, TrieNode> getChildNodes(){
            return childNodes;
        }

        public void setIsLast(boolean isLast){
            this.isLast = isLast;
        }
    }

    TrieNode rootNode;

    public WordDictionary() {
        rootNode = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode thisNode = this.rootNode;
        for(int i=0 ; i < word.length() ; i++){
            thisNode = thisNode.childNodes.computeIfAbsent(word.charAt(i) , node -> new TrieNode() );

        }
        thisNode.setIsLast(true);
    }

    public boolean search(String word) {
        TrieNode thisNode = this.rootNode;

        for(int i=0 ; i< word.length() ; i++){
            Character thisChar = word.charAt(i);
            if(thisChar.equals('.') && thisNode.childNodes.isEmpty()){
                return false;
            }
            thisNode = thisNode.childNodes.get(word.charAt(i));

            if(thisNode == null) return false;
            //.일때는 모두 해당!!
        }
        return thisNode.getIsLast();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */