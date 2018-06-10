/*
Description:Question 1 -- sortByStrings(s,t): Sort the letters in the string s 
    by the order they occur in the string t. You can assume t will not have 
    repetitive characters. For s = "weather" and t = "therapyw", the output 
    should be sortByString(s, t) = "theeraw". For s = "good" and t = "odg", the 
    output should be sortByString(s, t) = "oodg" 
*/

public class question1 {
    public static void main(String args[]) {
        //sortByStrings(s,t)
        System.out.println(sortByStrings("weather", "therapyw"));
    }
    
    public static String sortByStrings(String s, String t) {
        String sortedString = "";
        for(int i = 0; i < t.length(); i++)
        {
            for(int j = 0; j < s.length(); j++){
                
                if(t.charAt(i) == s.charAt(j)){
                    sortedString += s.charAt(j);
                }
            }
        }
       return sortedString;
    }
}