import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0 ; i<X.length() ; i++){
            char c = X.charAt(i);
            map.put(c, map.containsKey(c)?map.get(c)+1:1);
        }
        
        List<Character> list = new ArrayList<>();
        
        for(int i=0 ; i<Y.length() ; i++){
            char c = Y.charAt(i);
            if(map.containsKey(c)){
                list.add(c);
                if(map.get(c) == 1){
                    map.remove(c);
                }else{
                    map.put(c, map.get(c)-1);
                }
            }
        }
        
        if(list.isEmpty()) return "-1";
        
        Collections.sort(list, Collections.reverseOrder());
        
        if(list.get(0) == '0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        
        return sb.toString();
    }
}