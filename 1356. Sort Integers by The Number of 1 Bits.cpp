#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    static int count(int n){
        int c = 0;
        while(n){
            n &= (n - 1);
            c++;
        }
        return c;
    }
    static bool compare(int a, int b){
        int c1 = count(a);
        int c2 = count(b);

        if(c1 == c2){
            return a < b;  
        }
        return c1 < c2;
    }
    vector<int> sortByBits(vector<int>& arr) {
        sort(arr.begin(), arr.end(), compare);
        return arr;
    }
};