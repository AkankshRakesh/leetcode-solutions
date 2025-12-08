class Solution {
public:
    int countTriples(int n) {
        int ans = 0;
        for(int i = 2; i <= n; i++){
            int target = i * i;
            for(int a = 1; a < i; a++){
                int bSquare = target - (a * a);
                if(bSquare <= 0) continue;
                int b = (int)std::sqrt(bSquare);
                
                if(b * b == bSquare && a > b) ans += 2;
            }
        }
        return ans;
    }
};