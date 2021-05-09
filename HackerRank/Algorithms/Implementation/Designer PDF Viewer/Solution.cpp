//* https://www.hackerrank.com/challenges/designer-pdf-viewer

#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;


int main(){
    int n = 26;
    vector<int> h(n);
    for(int h_i = 0;h_i < n;h_i++)
       cin >> h[h_i];
    string word;
    cin >> word;
    
    int maxHeight = 0;
    for(int i = 0 ; i < word.length() ; i++) {
        int index = word[i] - 'a';
        if(h[index] > maxHeight) {
            maxHeight = h[index];
        }
    }
    
    cout << maxHeight*word.length() << endl;
    return 0;
}
