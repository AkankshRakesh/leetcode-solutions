class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int minCount = nums.length/3;
        int max1 = 0, max2 = 0, count1 = 0, count2 = 0;

        for(int num: nums){
            if(num == max1) count1++;
            else if(num == max2) count2++;
            else if(count1 == 0){
                max1 = num;
                count1++;
            }
            else if(count2 == 0){
                max2 = num;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int num: nums){
            if(num == max1) count1++;
            else if(num == max2) count2++;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        if(count1 > minCount) arr.add(max1);
        if(count2 > minCount) arr.add(max2);

        return arr;
    }
}