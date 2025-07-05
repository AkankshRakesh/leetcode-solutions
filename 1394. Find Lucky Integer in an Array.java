class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int num: arr){
            if(hm.containsKey(num)){
                int count = hm.get(num);
                hm.put(num, count + 1);
            }
            else hm.put(num, 1);
        }
        int maxLucky = -1;
        for(Integer num: hm.keySet()) if(hm.get(num) == num) maxLucky = maxLucky > num ? maxLucky : num;

        return maxLucky;
    }
}