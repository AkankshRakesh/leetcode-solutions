class Solution {
public:
    int maxDistance(const vector<int>& colors) {
        int ans = 0;
        for(int i = colors.size() - 1; i >= 1; i--){
            if(colors[i] != colors[0]){
                ans = max(ans, i);
                break;
            }
        }
        for(int i = 0; i < colors.size(); i++){
            if(colors[i] != colors[colors.size() - 1]){
                ans = max(ans, static_cast<int>(colors.size() - 1 - i));
                break;
            }
        }
        return ans;
    }
};