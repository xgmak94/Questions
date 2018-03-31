// https://www.hackerrank.com/challenges/sock-merchant

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n;
    cin >> n;
    vector<int> vec;
    for(int i = 0 ; i < n ; i++) {
        int temp;
        cin >> temp;
        vec.push_back(temp);
    }
    sort(vec.begin(), vec.end());
    
    int count = 0;
    for(int i = 0 ; i < n ; i++) {
        if(vec[i] == vec[i + 1]) {
            count++;
            i++;
        }
    }
    
    cout << count;
    
    return 0;
}
