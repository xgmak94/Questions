/*
Write a method - pow(x,n) that returns the value of x raised to the power of n (xn). n can be negative!
Examples:
pow(2,3) ==> 8.0

*/

public static double pow(double x, int n) {
    if(n == 0 || n == 1)
        return (n == 0) ? 1 : x;
    else if(n > 1)
        return x * pow(x, n - 1);
    else
        return 1/ (x * pow(x, n + 1));
}