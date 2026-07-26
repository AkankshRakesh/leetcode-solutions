class Solution {
    public int maximumProduct(int[] nums) {
        int first = -1001, second = -1001, third = -1001;
        int minFirst = -1001, minSecond = -1001;
        for(int num : nums){
            if(first == -1001) first = num;
            else if(second == -1001){
                if(num > first){
                    second = first;
                    first = num;
                }
                else second = num;
            }
            else if(third == -1001){
                if(num > first){
                    third = second;
                    second = first;
                    first = num;
                }
                else if(num > second){
                    third = second;
                    second = num;
                }
                else third = num;
            }
            else{
                if(num > first){
                    third = second;
                    second = first;
                    first = num;
                }
                else if(num > second){
                    third = second;
                    second = num;
                }
                else if(num > third) third = num;
            }

            if(minFirst == -1001) minFirst = num;
            else if(minSecond == -1001){
                if(num < minFirst){
                    minSecond = minFirst;
                    minFirst = num;
                }
                else minSecond = num;
            }
            else{
                if(num < minFirst){
                    minSecond = minFirst;
                    minFirst = num;
                }
                else if(num < minSecond) minSecond = num;
            }
        }

        return Math.max(first * second * third, minFirst * minSecond * first);
    }
}