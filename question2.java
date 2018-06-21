/*
Discussion: Question 2 -- decodeString(s): Given an encoded string, return its 
    corresponding decoded string. 

    The encoding rule is: k[encoded_string], where the encoded_string inside the 
    square brackets is repeated exactly k times. Note: k is guaranteed to be a 
    positive integer. 

    For s = "4[ab]", the output should be decodeString(s) = "abababab" 
    For s = "2[b3[a]]", the output should be decodeString(s) = "baaabaaa"
*/

import java.lang.*;
class question2 {
    
    public static void main(String args[]){
        System.out.println("DecodedString (4[ab]): " + decodeString("4[ab]"));
        System.out.println("DecodedString (2[b3[a]]): " + decodeString("2[b3[a]]"));
    }
    public static String decodeString(String s){
         if(s.length() <= 1){
            return "";
        }
        
        if(Character.isLetter(s.charAt(0))){
            return s;
        }
        int repeated = s.charAt(0) - 48;
        int timesToRepeat = s.charAt(0) - 48;
        int counter = 0;
        String digit = "";
        while(Character.isDigit(s.charAt(counter))){
            digit += s.charAt(counter);
            counter++;
        }
        timesToRepeat = Integer.parseInt(digit);

        repeated = Integer.parseInt(digit);
        
        String temp = "";
        String bucket = ""; 
        Boolean append = false;
        for(int i = 1; i < s.length(); i++){
            
            if(Character.isLetter(s.charAt(i))){
                temp += s.charAt(i);
            }
            if(s.charAt(i) == ']' && timesToRepeat != 0){
                temp = appendWord(timesToRepeat, temp);
                timesToRepeat = 0;
            }
            if(Character.isDigit(s.charAt(i))){
                if(Character.isLetter(s.charAt(i -1))){
                    append = true;
                }
                bucket += temp;
                timesToRepeat = s.charAt(i) - 48;
                temp = "";
            }
        }
        if(append){
            return appendWord(repeated, bucket + temp);
        }
        if(repeated >= 10){
            return appendWord(repeated, bucket + temp);
        }
        return bucket + temp;
    }
   
    public static String appendWord(int x, String word){
        String appendedWord = "";
        for(int i = 0; i < x; i++){
            appendedWord += word;
        }
        return appendedWord;   
    }
}