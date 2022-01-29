

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringUtils {

    public static int firstNonRepeatingCharacter(String str){
        Map<Character,Integer> characterFrequencyMap=new HashMap<>();
        char[] chars =str.toCharArray();
        for(char ch:chars){
            characterFrequencyMap.put(ch,characterFrequencyMap.getOrDefault(ch, 0)+1);
        }

        for(int i=0;i<chars.length;i++){
            char ch=chars[i];
            if(characterFrequencyMap.get(ch)==1){
                return i;
            }
        }
        return -1;
    }

    public static String removeVowels(String str){
        Set<Character> vowels=Set.of('a','e','i','o','u');
        StringBuilder sb=new StringBuilder();

        char[] charArray=str.toCharArray();
        for(Character ch:charArray){
            if(!vowels.contains(ch)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // System.out.println(firstNonRepeatingCharacter("abdcabce"));
        System.out.println(removeVowels("aeiou"));
    }
}
