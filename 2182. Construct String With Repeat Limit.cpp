int cnt_base[26],*cnt=cnt_base-'a';
class Solution {
public:
    string repeatLimitedString(string &s, int r) {
        memset(cnt_base,0,sizeof(cnt_base));
        for(char c:s) cnt[c]++;
        char i='z',j='y';
        int sz=0;
        while(i>='a'){
            if(cnt[i]==0){--i;continue;}
            if(cnt[i]>r){
                cnt[i]-=r;
                for(int t=0;t<r;++t) s[sz++]=i;
                while(j>=i) --j;
                while(j>='a'&&cnt[j]==0) --j;
                if(j=='a'-1){s.resize(sz);return s;}
                s[sz++]=j;
                cnt[j]--;
            }
            else{
                for(int t=0;t<cnt[i];++t) s[sz++]=i;
                --i;
            }
        }
        s.resize(sz);
        return s;
    }
};