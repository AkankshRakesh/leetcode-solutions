class Solution {
public:
    bool canChange(string start, string target) {
        int n1 = start.size(), n2 = target.size(), i = 0, j = 0;
        // bool firstCheck = true;
        while(i < n1 && j < n2){
            if(start[i] == '_'){
                i++;
                continue;
            }
            if(target[j] == '_'){
                j++;
                continue;
            }
            if(start[i] != target[j]) return false;
            else{
                if(start[i] == 'L' && i < j) return false;
                if(start[i] == 'R' && i > j) return false; 
                i++;
                j++;
            }
        }
        while(i < n1){
            if(start[i] != '_') return false;
            i++;
        }
        while(j < n2){
            if(target[j] != '_') return false;
            j++;
        }
        return true;
    }
};