import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : completion){
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }
        
        for(String s : participant){
            if(map.containsKey(s)){
                if(map.get(s)==1){
                    map.remove(s);
                }else{
                    map.put(s,map.get(s)-1);
                }
            }else{
                answer = s;
            }
        }
        
        return answer;
    }
}