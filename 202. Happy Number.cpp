class Solution {
public:
    bool isHappy(int n) {
        if(n == 1) return true;
        int arr[10] = {0,1, 4, 9, 16, 25, 36, 49, 64, 81};
        std::unordered_set<int> seen;
        while(n != 1 && seen.find(n) == seen.end()){
            seen.insert(n);
            int sum = 0, squareSum = 0;
            while(n){
                squareSum += arr[n % 10];
                sum += n % 10;
                n /= 10;
            }
            n = squareSum;
        }
        return n==1;
    }
};