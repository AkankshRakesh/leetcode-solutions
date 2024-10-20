class Solution {
public:
    vector<string> stringSequence(string target) {
        vector<string> result;
    string current = "";  
    char last_char = 'a'; 
    
    for (char ch : target) {
        current += 'a';
        result.push_back(current);  
        
        while (last_char != ch) {
            last_char++;
            if (last_char > 'z') {
                last_char = 'a';  
            }
            current.back() = last_char;
            result.push_back(current); 
        }
        last_char = 'a';  
    }

    return result;
    }
};