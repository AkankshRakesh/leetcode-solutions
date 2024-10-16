class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        priority_queue<pair<int, char>> pq;

        if (a > 0) pq.push({a, 'a'});
        if (b > 0) pq.push({b, 'b'});
        if (c > 0) pq.push({c, 'c'});

        string result = ""; 

        while (pq.size() > 1) {
            int freq1 = pq.top().first;
            char c1 = pq.top().second;
            pq.pop();  
            if (result.size() <= 1) {
                result += c1;
                freq1--; 
                if (freq1 > 0) pq.push({freq1, c1});
            } 
            else {
                if (result[result.size() - 1] == c1 && result[result.size() - 2] == c1) {
                    int freq2 = pq.top().first;
                    char c2 = pq.top().second;
                    pq.pop(); 

                    result += c2;
                    freq2--;  

                    if (freq2 > 0) pq.push({freq2, c2});
                    if (freq1 > 0) pq.push({freq1, c1});
                } 
                else {
                    result += c1;
                    freq1--;
                    if (freq1 > 0) pq.push({freq1, c1});
                }
            }
        }

        if (pq.size() == 1) {
            int freq1 = pq.top().first;
            char c1 = pq.top().second;
            
            if (freq1 <= 1) {
                result += c1;
            } else {
                result += c1;
                result += c1;
            }
        }

        return result; 
    }
};