const int mod = 1e9+7;
class Solution {
    int n, vis[202], dp[202][202];
private:
    int f(int prev, int len, string& s){
        if(len == n+1) return 1;
        if(dp[prev+1][len] != -1) return dp[prev+1][len];
        int ans = 0;
        if(prev == -1){
            for(int i=0; i<=n; i++){
                vis[i] = 1;
                ans = (ans + f(i,len+1,s))%mod;
                vis[i] = 0;
            }
        }
        else if(prev != -1 && s[len-1] == 'D'){
            for(int i=0; i<prev; i++){
                if(!vis[i]){
                    vis[i] = 1;
                    ans = (ans + f(i,len+1,s))%mod;
                    vis[i] = 0;
                }
            }
        }
        else if(prev != -1 && s[len-1] == 'I'){
            for(int i=prev+1; i<=n; i++){
                if(!vis[i]){
                    vis[i] = 1;
                    ans = (ans + f(i,len+1,s))%mod;
                    vis[i] = 0;
                }
            }
        }

        return dp[prev+1][len] = ans;
    }
public:
    int numPermsDISequence(string s) {
        n = s.size();
        memset(vis, 0, sizeof(vis));
        memset(dp, -1, sizeof(dp));
        return f(-1,0,s);
    }
};