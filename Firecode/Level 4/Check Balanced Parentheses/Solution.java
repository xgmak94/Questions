/*
Write a method to recursively check whether an equation has a balanced number of left and right parentheses and brackets - (including (,),[,],{,}).

Examples:
isBalanced("() [] ()") ==> true
isBalanced("([)]") ==> false 

*/

public static boolean isBalanced(String input) {
    int length = input.length();
    if(length % 2 == 1) // if odd that means its not balanced
        return false;
    
    Stack<Character> s = new Stack<>();
    
    for(int i = 0 ; i < length ; i++) {
        char c = input.charAt(i);
        
        if(c == '(' || c == '[' || c == '{')
            s.push(c);
        else if(c == ')' || c == ']' || c == '}') {
            if(s.isEmpty())
                return false;
                
            char openParen = s.pop();
            
            if(openParen != '(' && c == ')')
                return false;
            else if(openParen != '[' && c == ']')
                return false;
            else if(openParen != '{' && c == '}')
                return false;
        }
    }
    return (s.isEmpty()) ? true : false;
}