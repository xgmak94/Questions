// https://www.hackerrank.com/challenges/utopian-tree

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int t;
    cin >> t;
    for(int a0 = 0; a0 < t; a0++){
        int cycles;
        cin >> cycles;
        
        int height = 1;
        for(int i = 1 ; i <= cycles ; i++) {
            if(i % 2 == 0)
                height += 1;
            else if(i % 2 == 1)
                height *= 2;
        }
        cout << height << endl;
    }
    return 0;
}