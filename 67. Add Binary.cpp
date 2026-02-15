class Solution {
public:
    string addBinary(string a, string b) {
        int len1 = a.size(), len2 = b.size();
        int i = len1 - 1, j = len2 - 1, carry = 0;
        string arr;
        while(i >= 0 && j >= 0){
            int sum = (a[i] - '0') + (b[j] - '0') + carry;
            if(sum == 3){
                arr.push_back('1');
                carry = 1;
            }
            else if(sum == 2){
                arr.push_back('0');
                carry = 1;
            }
            else if(sum == 1){
                carry = 0;
                arr.push_back('1');
            }
            else{
                carry = 0;
                arr.push_back('0');
            }
            i--;
            j--;
        }
        while(i >= 0){
            int sum = (a[i] - '0') + carry;
            if(sum == 2){
                carry = 1;
                arr.push_back('0');
            }
            else if(sum == 1){
                carry = 0;
                arr.push_back('1');
            }
            else{
                arr.push_back('0');
            }
            i--;
        }
        while(j >= 0){
            int sum = (b[j] - '0') + carry;
            if(sum == 2){
                carry = 1;
                arr.push_back('0');
            }
            else if(sum == 1){
                carry = 0;
                arr.push_back('1');
            }
            else{
                arr.push_back('0');
            }
            j--;
        }
        if(carry) arr.push_back('1');
        int mid = arr.size()/2, size = arr.size();
        for(int k = 0; k < mid; k++){
            int temp = arr[k];
            arr[k] = arr[size - k - 1];
            arr[size - k - 1] = temp;
        }
        return arr;
    }
    
};