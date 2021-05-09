// https://www.hackerrank.com/challenges/bon-appetit

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int numItems, numSkip, charged, actual;
    numItems = numSkip = charged = actual = 0;
    
    cin >> numItems;
    cin >> numSkip;
    
    int itemsCost[numItems];
    for(int i = 0 ; i < numItems ; i++)
        cin >> itemsCost[i];
    
    cin >> charged;
    
    for(int i = 0 ; i < numItems ; i++)
        if(i != numSkip)
            actual += itemsCost[i];

    actual = actual / 2;
    
    int result = actual - charged;

    (result == 0) ? printf("Bon Appetit\n") : printf("%d\n", charged - actual); 

    return 0;
}
