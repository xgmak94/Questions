/*
mplement a method that reverses an integer - without using additional heap space
Examples:
-123 ==> -321
123 ==> 321
*/

public static int reverseInt(int x) {
    StringBuilder reversed = new StringBuilder();
    if(x < 0) {
        reversed.append('-');
        x = Math.abs(x);
    }
    while(x > 10) {
        reversed.append(x % 10);
        x = x / 10;
    }
    reversed.append(x);
    
    return Integer.parseInt(reversed.toString());
}