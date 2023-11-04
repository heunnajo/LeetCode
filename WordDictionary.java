import java.util.*;
class WordDictionary {
    HashMap<Integer,List<String>> map;
    public WordDictionary() {
        map = new HashMap<>();
    }
    
    public void addWord(String word) {
        int key = word.length();
        
        if(!map.containsKey(key)){
            List<String> list = new ArrayList<>();
            list.add(word);
            map.put(key,list);
        } else{
            map.get(key).add(word);
        }
        
    }
    
    public boolean search(String word) {
        int key = word.length();
        if(!map.containsKey(key)){
            return false;
        }
        
        List<String> list = map.get(key);
        for(String str:list){
            if(isSame(str,word)) return true;
        }
        return false;
    }
    public boolean isSame(String str,String word){
        //System.out.println("str: "+str+" word: "+word);
        for(int i=0;i<str.length();i++){
            if(word.charAt(i) != '.' && str.charAt(i) != word.charAt(i)) return false;
        }
        return true;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */