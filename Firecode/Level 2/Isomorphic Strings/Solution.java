/*
Given two strings - input1 and input2, determine if they are isomorphic. 
Two strings are isomorphic if the letters in one string can be remapped to get the second string. Remapping a letter means replacing all occurrences of it with another letter. The ordering of the letters remains unchanged. You can also think of isomorphism as it is used in chemistry - i.e. having the same form or overall shape. Target linear time and space complexity with your solution.

Examples:
Input 1 : css  
Input 2 : dll
Output  : true

Input 1 : css 
Input 2 : dle
Output  : false

Input 1 : abcabc 
Input 2 : xyzxyz
Output  : true

Input 1 : abcabc 
Input 2 : xbexyz
Output  : false
*/

public static boolean isIsomorphic(String input1, String input2) {
    if(input1 == null || input2 == null || input1.length() != input2.length())
        return false;
    
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    
    for(int i = 0 ; i < input1.length() ; i++) {
        char c1 = input1.charAt(i);
        Integer num1 = (map1.containsKey(c1) == true) ? map1.get(c1) + 1 : 1;
        map1.put(c1, num1);
        
        char c2 = input2.charAt(i);
        Integer num2 = (map2.containsKey(c2) == true) ? map2.get(c2) + 1 : 1;
        map2.put(c2, num2);
        
        if(map1.get(c1) != map2.get(c2))
            return false;
    }    
    return true;
}