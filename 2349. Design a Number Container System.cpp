class NumberContainers {
    public:
        
        unordered_map<int, set<int>> numberToIndices;
        unordered_map<int, int> indexToNumbers;
        NumberContainers() {}
        
        void change(int index, int number) {
            if (indexToNumbers.find(index) != indexToNumbers.end()) {
                int previousNumber = indexToNumbers[index];
                numberToIndices[previousNumber].erase(index);
                if (numberToIndices[previousNumber].empty()) {
                    numberToIndices.erase(previousNumber);
                }
            }
            indexToNumbers[index] = number;
            numberToIndices[number].insert(index);
        }
        
        int find(int number) {
            if (numberToIndices.find(number) != numberToIndices.end()) {
                return *numberToIndices[number].begin();
            }
            return -1;
        }
    };
    
    /**
     * Your NumberContainers object will be instantiated and called as such:
     * NumberContainers* obj = new NumberContainers();
     * obj->change(index,number);
     * int param_2 = obj->find(number);
     */