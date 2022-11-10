package solved;

import java.util.HashMap;
import java.util.Map;

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
//

    public boolean search(String word) {
        return dfsSearch(rootNode.childNodes , word,0);
    }


    private boolean dfsSearch(HashMap<Character, TrieNode> children, String word, int start){
        if(start == word.length()){
            if(children.size() == 0) return true;
            else return false;
        }

        char c = word.charAt(start);

        if(children.containsKey(c)){
            if(start == word.length()-1 && children.get(c).isLast){
                return true;
            }

            return dfsSearch(children.get(c).childNodes, word, start+1);
        } else if( c == '.'){
            boolean result = false;
            for(Map.Entry<Character, TrieNode> child : children.entrySet()){
                if(start == word.length()-1 && child.getValue().isLast){
                    return true;
                }

                if(dfsSearch(child.getValue().getChildNodes(), word, start+1)){
                    result = true;
                }
            }
            return result;
        } else return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */