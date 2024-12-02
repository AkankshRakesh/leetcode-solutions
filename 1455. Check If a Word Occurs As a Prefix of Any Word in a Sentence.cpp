class Solution {
public:
    int isPrefixOfWord(const std::string& sentence, const std::string& searchWord) {
    istringstream ss(sentence);
    string word;
    int index = 1;

    while (ss >> word) {
        if (word.rfind(searchWord, 0) == 0) { // Check prefix
            return index;
        }
        index++;
    }
    return -1;
}
};