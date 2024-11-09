class Solution {
public:
    int prod(int n){
        int prod = 1;
        while(n){
            prod *= n % 10;
            n /= 10;
        }
        return prod;
    }
    int smallestNumber(int n, int t) {
        int temp = prod(n);
        while(temp % t != 0){
            n++;
            temp = prod(n);
        }
        return n;
    }
};