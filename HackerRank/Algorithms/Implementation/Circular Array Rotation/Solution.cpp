// https://www.hackerrank.com/challenges/circular-array-rotation

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int nInts, kRotations , qQueries;
    
    cin >> nInts >> kRotations >> qQueries;

    int nums[nInts];
    int rotated[nInts];
    
    for(int i = 0 ; i < nInts ;i++) {
        int temp;
        cin >> nums[i];
    }
    
    for(int i = 0 ; i < nInts ; i++)
        rotated[(i + kRotations) % nInts] = nums[i];

    for(int i = 0 ; i < qQueries ; i++) {
        int query;
        cin >> query;
        cout << rotated[query] << endl;
    }
   


    
    return 0;
}
